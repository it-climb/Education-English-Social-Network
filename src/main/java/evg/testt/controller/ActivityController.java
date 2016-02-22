package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.service.ActivityService;
import evg.testt.service.UserDataService;
import evg.testt.service.UserService;
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
public class ActivityController {

//    @Autowired
//    UserDataService userDataService;
//
//    @Autowired
//    UserService userService;

    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public ModelAndView showAccount(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            ModelAndView modelAndView = new ModelAndView(JspPath.ISE_ERROR_VIEW);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.ACTIVITIES_SHOW);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("activities", activityService.getAll());
        return modelAndView;
    }

//    @RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
//    public String addNewOne(@RequestParam(required = false) Integer accountId,@RequestParam(required = false) Integer userId,@ModelAttribute User user,@ModelAttribute UserData userData) throws SQLException {
//        userData.setId(accountId);
//        user.setId(userId);
//        userData.setUser(user);
//        userDataService.update(userData);
//        return "redirect:/account";
//    }
}
