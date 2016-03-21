package evg.testt.controller;

import evg.testt.dto.ReadActivityDto;
import evg.testt.dto.WatchActivityDto;
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
import org.mvel2.debug.Debugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Array;
import java.sql.SQLException;
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

    @RequestMapping(value = {"/addReadActivity"}, method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    //@RequestMapping(value = "/addReadActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("raDTO") ReadActivityDto readActivityDto,
                              @RequestParam(required = true, name="listOfSubj") String[] list,
                              HttpServletRequest request)throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        Activity activity = new Activity();
        activity.setType(ActivityType.READING_ACTIVITY);
        activity.setName(readActivityDto.getName());
        activity.setAuthor(userDataService.findByUser(sessionUser));

        ReadingActivityContent content = new ReadingActivityContent();
        content.setText(readActivityDto.getText());

        ReadingActivity readingActivity = new ReadingActivity();
        readingActivity.setActivity(activity);
        readingActivity.setContent(content);
        readingActivityService.insert(readingActivity);
        return "redirect:/activities";
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


    @RequestMapping(value = "/updateReadActivity", method = RequestMethod.POST)
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
