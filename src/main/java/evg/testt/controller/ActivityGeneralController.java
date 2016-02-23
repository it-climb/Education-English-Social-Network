package evg.testt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityGeneralController {

    @RequestMapping(value = "/addGeneralActivity", method = RequestMethod.POST)
    public String addGeneralActivity(){
        return null;
    }

}
