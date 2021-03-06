package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import evg.testt.util.converter.EmailConverter;
import evg.testt.util.validation.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Converter;
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

    /**
     * This method show user login page(with fields asking you to enter your email and password)
     * or enter the page with user registration/
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.USER_LOGIN);
        }else
            return new ModelAndView(JspPath.USER_LOGIN, "email", sessionUser.getEmail());
    }

    /**
     * Show the page with user registration (fields asking you to enter email password and confirm password)
     * @return
     */
    @RequestMapping(value = "/regSave", method = RequestMethod.GET)
    public ModelAndView registration(){
        User user = new User();
        return new ModelAndView(JspPath.USER_REGISTRATION,"user",user);
    }

    /**
     * Add new user in DB if you entered write information in fields of adding user(enter email password and confirm password)
     * in not, write about your mistakes
     * If you enter email add password that already exist in DB write your mistakes
     * If all is clear send you to registration page with your name and email
     * @param user
     * @param  result
     * @param request
     * @return
     * @throws SQLException
     */

    @RequestMapping(value = "/regSave", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("user") User user, BindingResult result,
                             HttpServletRequest request)throws SQLException{
        //userValid.validate(user, result);
        if(result.hasErrors()){
            return "users/registration";
        }
        else{
            HttpSession session = request.getSession();
            userService.insert(user);
            session.setAttribute("user", user);
        }
        return "redirect:/login";
    }

    /**
     *Method act when you entered your email and password
     * @param email
     * @param password
     * @param request
     * @return all is write - page success (Success)
     * something is wrong - page loginProblems ("Incorrect email ! Try again")
     * @throws SQLException
     */

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request) throws SQLException {
            HttpSession session = request.getSession();
            User user = userService.getByEmail(email);
        if(user!=null && user.getPassword().equals(password/*Integer.toString(password.hashCode())*/)) {
                session.setAttribute("user", user);
                return "redirect:/success";
            }else return "redirect:/loginProblems";
    }

    /**
     *Method showing login problems when you try to add new user
     *  described in user model and messages.properties:
     *
     * @param user
     * @return
     */

    @RequestMapping(value = "/loginProblems", method = RequestMethod.GET)
    public ModelAndView showLoginProblems(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_LOGIN_PROBLEM);
        return modelAndView;
    }

}
