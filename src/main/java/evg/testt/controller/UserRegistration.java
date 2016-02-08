package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserRegistration {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/regSave1", method = RequestMethod.GET)
    public ModelAndView show(Map<String,Object> model){
        User user = new User();
        model.put("userForm",user);
        return new ModelAndView(JspPath.USER_REGISTRATION1);

    }


    @RequestMapping(value = "/regSave1", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("userForm") User userForm, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/registration1";
        }
        else return "redirect:/login";
    }


}
