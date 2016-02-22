package evg.testt.controller;

import evg.testt.model.userActionModels.UserAction;
import evg.testt.service.UserActionService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserActionController {

    @Autowired
    private UserActionService userActionService;

    @RequestMapping(value = "/usersAct", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_ACTION);
        modelAndView.addObject("userActions", userActionService.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/actionsList", method = RequestMethod.GET)
    public ModelAndView showAllActions(@RequestParam(required = true)Long id){
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_LIST_ACTION);
        UserAction userAction = userActionService.get(id);
        modelAndView.addObject("listActions", userAction.getActions());
        return modelAndView;
    }
}
