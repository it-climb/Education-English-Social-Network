package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.service.ActivityCommonService;
import evg.testt.service.ActivityService;
import evg.testt.service.UserDataService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class ActivityController {

    @Autowired
    UserDataService userDataService;

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityCommonService activityCommonService;

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public ModelAndView showAccount(HttpServletRequest request,
                                    @RequestParam(required = false) Integer number,
                                    @RequestParam(required = false) Integer page,
                                    @RequestParam(required = false) String author) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        if (number == null) {
            number = 10;
        }
        if (page == null) {
            page = 0;
        }
        Pageable paginator = new PageRequest(page, number);
        ModelAndView modelAndView = new ModelAndView(JspPath.ACTIVITIES_SHOW);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("paginator", paginator);
        if (author == null || author.isEmpty()) {
            return modelAndView.addObject("activities", activityService.getAll(paginator).getContent());
        }
        UserData authorUserData = userDataService.findByUser(userService.getByEmail(author));
        modelAndView.addObject("author", author);
        return modelAndView.addObject("activities", activityCommonService.getActivityByAuthor(authorUserData,
                paginator).getContent());
    }

    @RequestMapping(value = "/createTestActivities", method = RequestMethod.POST)
    public String addTestActivities(HttpServletRequest request, @RequestParam(required = true) String num) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        UserData sessionUserData = userDataService.findByUser(sessionUser);
        Activity testActivity = Activity.newBuilder().setName(num+"Name").setTargetAge(num+"Age")
                .setActivityType(ActivityType.WATCHING_TEST_ACTIVITY).setAuthor(sessionUserData).build();
            activityService.insert(testActivity);
        return "redirect:/activities";
    }

//    @RequestMapping(value = "/addSubjectInActivity", method = RequestMethod.POST)
//    public String addSubject(HttpServletRequest request,
//                             @RequestParam(required = true) String name,
//                             @RequestParam(required = true) Integer activityID) throws SQLException {
//        HttpSession session = request.getSession();
//        User sessionUser = (User) session.getAttribute("user");
//        UserData sessionUserData = userDataService.findByUser(sessionUser);
////        Subject sub =
//
//        return "redirect:/activities";
//    }


//    @RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
//    public String addNewOne(@RequestParam(required = false) Integer accountId,@RequestParam(required = false) Integer userId,@ModelAttribute User user,@ModelAttribute UserData userData) throws SQLException {
//        userData.setId(accountId);
//        user.setId(userId);
//        userData.setUser(user);
//        userDataService.update(userData);
//        return "redirect:/account";
//    }
}
