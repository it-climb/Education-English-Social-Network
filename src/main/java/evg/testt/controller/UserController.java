package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.service.UserDataService;
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

import javax.jws.soap.SOAPBinding;
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

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.USER_LOGIN);
        }else
            return new ModelAndView(JspPath.USER_LOGIN, "email", sessionUser.getEmail());
    }

    @RequestMapping(value = "/regSave", method = RequestMethod.GET)
    public ModelAndView registration(){
        User user = new User();
        UserData userData = new UserData();
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_REGISTRATION);
        modelAndView.addObject("user", user);
        modelAndView.addObject("userData", userData);
        return modelAndView;
    }


    @RequestMapping(value = "/regSave", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("user") User user,
                             @ModelAttribute("userData") UserData userData,
                             /*@RequestParam(required = true) String email,
                             @RequestParam(required = true) String password,
//                             @RequestParam(required = true) String confirmPassword,
                             @RequestParam(required = true) String firstName,
                             @RequestParam(required = true) String secondName,
                             @RequestParam(required = true) Integer age,*/
                             BindingResult result,
                             HttpServletRequest request)throws SQLException{
        //userValid.validate(user, result);
        if(result.hasErrors()){
            return "users/registration";
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            userService.insert(user);
            userData = UserData.newBuilder().setUser(user).setAge(userData.getAge()).setFirstName(userData.getFirstName()).setSecondName(userData.getSecondName()).setGender(userData.getGender()).build();
            userDataService.insert(userData);
//            UserData userData = userDataService.findByUser(user);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request) throws SQLException {
            HttpSession session = request.getSession();
            User user = userService.getByEmail(email);
        if(user!=null && user.getPassword().equals(password/*Integer.toString(password.hashCode())*/)) {
                session.setAttribute("user", user);
                return "redirect:/success";
            }else return "redirect:/loginProblems";
    }

    @RequestMapping(value = "/loginProblems", method = RequestMethod.GET)
    public ModelAndView showLoginProblems(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_LOGIN_PROBLEM);
        return modelAndView;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            ModelAndView modelAndView = new ModelAndView(JspPath.ISE_ERROR_VIEW);
            return modelAndView;
        }else {
            session.invalidate();
        }
        return new ModelAndView(JspPath.HOME);
    }

}
