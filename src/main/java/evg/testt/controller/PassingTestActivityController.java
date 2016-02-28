package evg.testt.controller;

import evg.testt.util.JspPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PassingTestActivityController {

    boolean oneAnswer = true;

    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public ModelAndView showAll(){
        if (oneAnswer) {
            return new ModelAndView(JspPath.PASSING_TEST_ALL_WITH_BOX);
        }
        else {
            return new ModelAndView(JspPath.PASSING_TEST_ALL_WITH_BUTTON);
        }
    }





}
