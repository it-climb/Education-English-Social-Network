package evg.testt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("fortraining")
public class ForTrainingController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String myTraining(){
        return "ForTraining";
    }
}
