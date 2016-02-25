package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.util.JspPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ActivityGeneralController {


    @RequestMapping(value = "/addGeneralActivity", method = RequestMethod.GET)
    public ModelAndView showAdd(){
        return new ModelAndView(JspPath.ACTIVITY_GENERAL_ADD);
    }

    @RequestMapping(value = "/addGeneralActivity", method = RequestMethod.POST)
    public String addGeneralActivity(){
        return null;
    }

    @RequestMapping(value = "/viewGeneralActivity", method = RequestMethod.GET)
    public ModelAndView showView(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.ACTIVITY_GENERAL_VIEW);
        modelAndView.addObject("userEmail",sessionUser.getEmail());
        return modelAndView;
    }

}
