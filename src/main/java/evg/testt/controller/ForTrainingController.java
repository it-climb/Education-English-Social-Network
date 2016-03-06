package evg.testt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForTrainingController {

    @RequestMapping(value = "fortraining", method = RequestMethod.GET)
    public String myTraining(){
        return "ForTraining";
    }


    @RequestMapping(value = "fortrain_2", method = RequestMethod.GET)
    public String myTrain_2(){
        return "ForTrain_2";
    }

}
