package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import evg.testt.util.validation.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.USER_LOGIN);
        }else
            return new ModelAndView(JspPath.USER_LOGIN, "email", sessionUser.getEmail());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        return new ModelAndView(JspPath.USER_REGISTRATION);
    }


    @RequestMapping(value = "/regSave", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("user") User user, HttpServletRequest request, BindingResult result ) throws SQLException{
       // userValid.validate(user, result);

        if(result.hasErrors()){
           return "redirect:/loginProblems";
        } else {
            HttpSession session = request.getSession();
            userService.insert(user);
            session.setAttribute("user", user);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request) throws SQLException {
            HttpSession session = request.getSession();
            User user = userService.getByEmail(email);
            if(user!=null && user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                return "redirect:/success";
            }else return "redirect:/loginProblems";
    }

    @RequestMapping(value = "/loginProblems", method = RequestMethod.GET)
    public ModelAndView showLoginProblems(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_LOGI_PROBLEM);
        return modelAndView;
    }

}
