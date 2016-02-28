package evg.testt.controller;

import evg.testt.dto.WatchActivityDto;
import evg.testt.model.User;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.WatchingActivity;
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

    @RequestMapping(value = "/addWatchActivity", method = RequestMethod.GET)
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
    public ModelAndView showActivity(){
        ModelAndView modelAndView = new ModelAndView(JspPath.WATCHING_ACTIVITY_VIEW);
        String url = "https://www.youtube.com/embed/gQHddcdwDMQ";
        String nameAuthor = "Sergei Bragin";
        String nameActivity = "BAT METAL !!!!";
        String describe = "METAL IS LIVE !!!! ";

        modelAndView.addObject("URL", url);
        modelAndView.addObject("nameAuthor", nameAuthor);
        modelAndView.addObject("nameActivity", nameActivity);
        modelAndView.addObject("describe", describe);

        return modelAndView;
    }

}
