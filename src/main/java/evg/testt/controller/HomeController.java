package evg.testt.controller;

import evg.testt.util.JspPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    /**
     * Show or return you to the basic EESN page
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) {
        //ModelAndView modelAndView = new ModelAndView("contacts/all");
        //modelAndView.addObject("contacts", contactService.getAll());
        //HttpSession session = request.getSession();
        return new ModelAndView(JspPath.HOME);
    }

    @RequestMapping(value = "/except", method = RequestMethod.GET)
    public ModelAndView showExcept() {
        ModelAndView modelAndView = new ModelAndView("/exceptions/except");
        return modelAndView;
    }
}

