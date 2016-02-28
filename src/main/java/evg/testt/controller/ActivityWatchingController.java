package evg.testt.controller;

import evg.testt.dto.WatchActivityDto;
import evg.testt.model.User;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.WatchingActivity;
import evg.testt.model.activitycontent.ActivityContent;
import evg.testt.model.activitycontent.WatchingActivityContent;
import evg.testt.service.UserDataService;
import evg.testt.service.WatchingActivityService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class ActivityWatchingController {

    @Autowired
    private WatchingActivityService watchingActivityService;
    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/activityContents", method = RequestMethod.GET)
    public ModelAndView showAddActivity(){
        return new ModelAndView(JspPath.WATCHING_ACTIVITY_ADD);
    }

    @RequestMapping(value = "/addWatchActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("waDto") WatchActivityDto watchActivityDto, HttpServletRequest request)throws SQLException{

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        Activity activity = new Activity();
        activity.setType(ActivityType.WATCHING_ACTIVITY);
        activity.setName(watchActivityDto.getName());
        activity.setAuthor(userDataService.findByUser(sessionUser));

        WatchingActivityContent content = new WatchingActivityContent();
        content.setUrl(watchActivityDto.getUrl());
        content.setDescription(watchActivityDto.getDescription());

        WatchingActivity watchingActivity = new WatchingActivity();
        watchingActivity.setActivity(activity);
        watchingActivity.setContent(content);
        watchingActivityService.insert(watchingActivity);
        return "redirect:/success";
    }

    @RequestMapping(value = "/watchActivity", method = RequestMethod.GET)
    public ModelAndView showActivity()throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.WATCHING_ACTIVITY_VIEW);
        WatchingActivity watchingActivity = watchingActivityService.getById(1);
        Activity activity = watchingActivity.getActivity();
        WatchingActivityContent content = watchingActivity.getContent();

        modelAndView.addObject("URL", content.getUrl());
        modelAndView.addObject("nameAuthor", activity.getAuthor().getUser().getEmail());
        modelAndView.addObject("nameActivity", activity.getName());
        modelAndView.addObject("describe", content.getDescription());

        return modelAndView;
    }

}
