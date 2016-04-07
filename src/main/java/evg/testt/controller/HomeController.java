package evg.testt.controller;

import evg.testt.dto.RegAndLoginDto;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.service.UserDataService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import evg.testt.util.validation.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) {
        //ModelAndView modelAndView = new ModelAndView("contacts/all");
        //modelAndView.addObject("contacts", contactService.getAll());
        HttpSession session = request.getSession();
        User userReg = new User();
        UserData userDataReg = new UserData();
        User userLog = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.HOME);
//        modelAndView.addObject("userReg", userReg);
//        modelAndView.addObject("userDataReg", userDataReg);
        RegAndLoginDto dto = new RegAndLoginDto();
        modelAndView.addObject("dto", dto);
        if (userLog != null) {

            modelAndView.addObject("email", userLog.getEmail());
        }
        return modelAndView;
//        return new ModelAndView(JspPath.HOME);
    }

    @RequestMapping(value = "/except", method = RequestMethod.GET)
    public ModelAndView showExcept() {
        ModelAndView modelAndView = new ModelAndView("/exceptions/except");
        return modelAndView;
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("dto") RegAndLoginDto dto,
//                             @RequestParam(required = false) String fullName,
//                             @ModelAttribute("userData") UserData userData,
//                             BindingResult result,
                             HttpServletRequest request)throws SQLException {
        //userValid.validate(user, result);
//        if(result.hasErrors()){
//            return "users/registration";
//        }else{
            HttpSession session = request.getSession();
        User user = User.newBuilder().setEmail(dto.getEmail()).setPassword(dto.getPassword()).build();
            session.setAttribute("user", user);
            userService.insert(user);
           UserData userData = UserData.newBuilder().setUser(user).setFirstName(dto.getFirstName()).setSecondName(dto.getSecondName()).build();
            userDataService.insert(userData);
////            UserData userData = userDataService.findByUser(user);
//        }
        return "redirect:/";
    }
// @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
//    public String addNewUser(@ModelAttribute("userReg") User userReg,
//                             @RequestParam(required = false) String fullName,
////                             @ModelAttribute("userData") UserData userData,
////                             BindingResult result,
//                             HttpServletRequest request)throws SQLException {
//        //userValid.validate(user, result);
////        if(result.hasErrors()){
////            return "users/registration";
////        }else{
//            HttpSession session = request.getSession();
//            session.setAttribute("user", userReg);
//            userService.insert(userReg);
//        System.out.println(fullName);
//           UserData userData = UserData.newBuilder().setUser(userReg).setFullName(fullName).build();
//            userDataService.insert(userData);
//////            UserData userData = userDataService.findByUser(user);
////        }
//        return "redirect:/";
//    }

    @RequestMapping(value = "/userLog", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password,
                            HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User user = userService.getByEmail(email);
        if(user!=null && user.getPassword().equals(password/*Integer.toString(password.hashCode())*/)) {
            session.setAttribute("user", user);
            return "redirect:/";
        }else return "redirect:/loginProblems";
    }
}

