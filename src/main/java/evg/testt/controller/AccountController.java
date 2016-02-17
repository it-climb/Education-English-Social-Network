package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.model.UserData;
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

import java.sql.SQLException;

@Controller
public class AccountController {

    @Autowired
    UserDataService userDataService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView showAccount() throws SQLException {
        return new ModelAndView(JspPath.ACCOUNT_SHOW, "account", userDataService.getById(1));
    }

    @RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = false) Integer accountId,@RequestParam(required = false) Integer userId,@ModelAttribute User user,@ModelAttribute UserData userData) throws SQLException {
        userData.setId(accountId);
        user.setId(userId);
        userData.setUser(user);
        userDataService.update(userData);
        return "redirect:/account";
    }
}
