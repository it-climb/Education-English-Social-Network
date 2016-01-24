package evg.testt.controller;

import evg.testt.model.Contact;
import evg.testt.service.ContactService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created on 9/10/15.
 */
@Controller
public class MainController {

    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) {
        //ModelAndView modelAndView = new ModelAndView("contacts/all");
        //modelAndView.addObject("contacts", contactService.getAll());
        HttpSession session = request.getSession();
        return new ModelAndView(JspPath.HOME);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("contacts/add_form", "contact", new Contact());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView showSuccess(@ModelAttribute Contact contact) {
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) Long id) {
        return new ModelAndView("contacts/add_form", "contact", contactService.get(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteContact(@RequestParam(required = true) Long id) {
        contactService.remove(id);
        return "redirect:/";
    }

}
