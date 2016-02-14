package evg.testt.controller;

import evg.testt.model.Comment;
import evg.testt.model.Contact;
import evg.testt.service.CommentService;
import evg.testt.service.ContactService;
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

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ContactService contactService;


    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) {
//        ModelAndView modelAndView = new ModelAndView("comments/all");
        ModelAndView modelAndView = new ModelAndView("comments/all");
//        Contact contact = contactService.get(id);
//        modelAndView.addObject("contacts", contact);
        modelAndView.addObject("comments", commentService.getAll());
//        modelAndView.addObject("comments", commentService.getAll());
        HttpSession session = request.getSession();
        return modelAndView;
    }

    @RequestMapping(value = "/commenta", method = RequestMethod.GET)
    public ModelAndView showA(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true) Integer id) {
//        ModelAndView modelAndView = new ModelAndView("comments/all");
        ModelAndView modelAndView = new ModelAndView("comments/allByDep");
//        Contact contact = contactService.get(id);
//        modelAndView.addObject("contacts", contact);
        modelAndView.addObject("comments", commentService.getByDep(id));
//        modelAndView.addObject("comments", commentService.getAll());
        HttpSession session = request.getSession();
        return modelAndView;
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("comments/add_form", "comment", new Comment());
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return "redirect:/dep";
    }

//    @RequestMapping(value = "/success", method = RequestMethod.GET)
//    public ModelAndView showSuccess(@ModelAttribute Comment comment) {
//        ModelAndView modelAndView = new ModelAndView("success");
//        return modelAndView;
//    }

    @RequestMapping(value = "/editComment", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) Long id) {
        return new ModelAndView("comments/add_form", "comment", commentService.get(id));
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public String deleteContact(@RequestParam(required = true) Long id) {
        commentService.remove(id);
        return "redirect:/comment";
    }




}
