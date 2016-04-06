package evg.testt.controller;

import com.google.api.client.json.Json;
import evg.testt.dto.ReadActivityDto;
import evg.testt.dto.WatchActivityDto;
import evg.testt.model.Subject;
import evg.testt.model.SubjectDifficult;
import evg.testt.model.User;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.ReadingActivity;
import evg.testt.model.activities.WatchingActivity;
import evg.testt.model.activitycontent.ReadingActivityContent;
import evg.testt.model.activitycontent.WatchingActivityContent;
import evg.testt.service.ReadingActivityService;
import evg.testt.service.UserDataService;
import evg.testt.service.WatchingActivityService;
import evg.testt.util.JspPath;
import jdk.nashorn.internal.runtime.Debug;
import org.bouncycastle.math.raw.Mod;
import org.mvel2.debug.Debugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Controller
public class ActivityReadingController {

    @Autowired
    private ReadingActivityService readingActivityService;
    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/addReadActivity", method = RequestMethod.GET)
    public ModelAndView showAddActivity(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return new ModelAndView(JspPath.READING_ACTIVITY_ADD);
    }

    @RequestMapping(value = "/addReadActivity", method = RequestMethod.POST)
    public ModelAndView addActivity(@ModelAttribute("raDto") ReadActivityDto readActivityDto,
                    HttpServletRequest request)throws SQLException{
        String[] subjects = request.getParameterValues("subject");
        String[] subjectsDiff = request.getParameterValues("subjectDifficult");
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        Activity activity = new Activity();
        activity.setType(ActivityType.READING_ACTIVITY);
        activity.setName(readActivityDto.getName());
        activity.setAuthor(userDataService.findByUser(sessionUser));

        Set<Subject> subject = null;
        for(int i = 0;i < subjects.length;i++)
        {
            SubjectDifficult subjectDiff = null;
            if(subjectsDiff[i].equals("easy")) {
                subjectDiff = SubjectDifficult.EASY;
            }
            if(subjectsDiff[i].equals("medium")) {
                subjectDiff = SubjectDifficult.NORMAL;
            }
            if(subjectsDiff[i].equals("hard")) {
                subjectDiff = SubjectDifficult.HARD;
            }
            Subject subjectInSet = new Subject();
            subjectInSet.setName(subjects[i]);
            subjectInSet.setSubjectDifficult(subjectDiff);
            subjectInSet.setActivity(activity);
            subject.add(subjectInSet);
            int x = subject.size();
        }

        ReadingActivityContent content = new ReadingActivityContent();
        content.setText(readActivityDto.getText());
        content.setSubjects(subject);

        ReadingActivity readingActivity = new ReadingActivity();
        readingActivity.setActivity(activity);
        readingActivity.setContent(content);
        readingActivityService.insert(readingActivity);
        return new ModelAndView(JspPath.ACTIVITIES_SHOW);
    }

    @RequestMapping(value = "/readActivity", method = RequestMethod.GET)
    public ModelAndView showActivity(@RequestParam(required = true) Integer id)throws SQLException{

        ModelAndView modelAndView = new ModelAndView(JspPath.READING_ACTIVITY_VIEW);
        ReadingActivity readingActivity = readingActivityService.getById(id);
        Activity activity = readingActivity.getActivity();
        ReadingActivityContent content = readingActivity.getContent();

        modelAndView.addObject("text", content.getText());
        modelAndView.addObject("nameAuthor", activity.getAuthor().getUser().getEmail());
        modelAndView.addObject("nameActivity", activity.getName());
        return modelAndView;
    }

    @RequestMapping(value = "/updateReadActivity", method = RequestMethod.GET)
    public ModelAndView showUpdateActivity(@RequestParam(required = true) Integer id)throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.READING_ACTIVITY_UPDATE);
        ReadingActivity readingActivity = readingActivityService.getById(id);
        Activity activity = readingActivity.getActivity();
        ReadingActivityContent content = readingActivity.getContent();
        ReadActivityDto readActivityDto = new ReadActivityDto();

        readActivityDto.setText(content.getText());
        readActivityDto.setName(activity.getName());

        modelAndView.addObject("updateRADto", readActivityDto);
        modelAndView.addObject("id", id);
        return modelAndView;
    }


    @RequestMapping(value = "/updateReadActivity", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateActivity(@ModelAttribute("updateRADto") ReadActivityDto readActivityDto,
                                 @RequestParam(required = true) Integer id)throws SQLException{

        ReadingActivity readingActivity = readingActivityService.getById(id);
        Activity activity = readingActivity.getActivity();
        ReadingActivityContent content = readingActivity.getContent();

        activity.setName(readActivityDto.getName());
        content.setText(readActivityDto.getText());

        readingActivity.setContent(content);
        readingActivity.setActivity(activity);

        readingActivityService.update(readingActivity);
        return "redirect:/activities";
    }


    @RequestMapping(value = "/deleteReadActivity", method = RequestMethod.GET)
    public String deleteActivity(@RequestParam(required = true) Integer id) throws SQLException{
        ReadingActivity activity = readingActivityService.getById(id);
        readingActivityService.delete(activity);
        return "redirect:/activities";
    }

}
