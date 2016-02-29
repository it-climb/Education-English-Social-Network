package evg.testt.controller;

import evg.testt.model.activitycontent.PassingTestData;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PassingTestActivityController {



    boolean oneAnswer = true;

    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public ModelAndView showAll(){
//        if (oneAnswer) {
//            return new ModelAndView(JspPath.PASSING_TEST_ALL_WITH_BOX);
//        }
//        else {
//            return new ModelAndView(JspPath.PASSING_TEST_ALL_WITH_BUTTON);
//        }

        return new ModelAndView(JspPath.PASSING_TEST_EDIT);
    }

    @RequestMapping(value = "/newTestQ", method = RequestMethod.POST)
    public ModelAndView newTestQ(){
        return new ModelAndView(JspPath.PASSING_TEST_EDIT);
    }

    @RequestMapping(value = "/saveQ", method = RequestMethod.POST)
    public String saveQ(@RequestParam(required = true) Integer id, String question, List<String> answers){
        PassingTestData passingTestData = new PassingTestData();
        passingTestData.setQuestion(question);


        return "redirect:/newTestQ";
    }





}
