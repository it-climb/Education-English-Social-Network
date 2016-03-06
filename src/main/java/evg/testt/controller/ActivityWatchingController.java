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
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView showAddActivity(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return new ModelAndView(JspPath.WATCHING_ACTIVITY_ADD);
    }

    @RequestMapping(value = "/addWatchActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("waDto") WatchActivityDto watchActivityDto,
                              HttpServletRequest request)throws SQLException{

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
        return "redirect:/activities";
    }

    @RequestMapping(value = "/watchActivity", method = RequestMethod.GET)
    public ModelAndView showActivity(@RequestParam(required = true) Integer id)throws SQLException{

        ModelAndView modelAndView = new ModelAndView(JspPath.WATCHING_ACTIVITY_VIEW);
        WatchingActivity watchingActivity = watchingActivityService.getById(id);
        Activity activity = watchingActivity.getActivity();
        WatchingActivityContent content = watchingActivity.getContent();

        modelAndView.addObject("URL", content.getUrl());
        modelAndView.addObject("nameAuthor", activity.getAuthor().getUser().getEmail());
        modelAndView.addObject("nameActivity", activity.getName());
        modelAndView.addObject("describe", content.getDescription());

        return modelAndView;
    }

    @RequestMapping(value = "/updateWatchActivity", method = RequestMethod.GET)
    public ModelAndView showUpdateActivity(@RequestParam(required = true) Integer id)throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.WATCHING_ACTIVITY_UPDATE);
        WatchingActivity watchingActivity = watchingActivityService.getById(id);
        Activity activity = watchingActivity.getActivity();
        WatchingActivityContent content = watchingActivity.getContent();
        WatchActivityDto watchActivityDto = new WatchActivityDto();

        watchActivityDto.setDescription(content.getDescription());
        watchActivityDto.setName(activity.getName());
        watchActivityDto.setUrl(content.getUrl());

        modelAndView.addObject("updateWADto", watchActivityDto);
        modelAndView.addObject("id", id);
        return modelAndView;
    }


    @RequestMapping(value = "/updateWatchActivity", method = RequestMethod.POST)
    public String updateActivity(@ModelAttribute("updateWADto") WatchActivityDto watchActivityDto,
                                 @RequestParam(required = true) Integer id)throws SQLException{

        WatchingActivity watchingActivity = watchingActivityService.getById(id);
        Activity activity = watchingActivity.getActivity();
        WatchingActivityContent content = watchingActivity.getContent();

        activity.setName(watchActivityDto.getName());
        content.setUrl(watchActivityDto.getUrl());
        content.setDescription(watchActivityDto.getDescription());

        watchingActivity.setContent(content);
        watchingActivity.setActivity(activity);

        watchingActivityService.update(watchingActivity);
        return "redirect:/activities";
    }


    @RequestMapping(value = "/deleteWatchActivity", method = RequestMethod.GET)
    public String deleteActivity(@RequestParam(required = true) Integer id) throws SQLException{
        WatchingActivity activity = watchingActivityService.getById(id);
        watchingActivityService.delete(activity);
        return "redirect:/activities";
    }

}
