package evg.testt.controller;

import evg.testt.util.JspPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivityWatchingController {

    //TODO Service level

    @RequestMapping(value = "/watchActivity", method = RequestMethod.GET)
    public ModelAndView showActivity(){
        ModelAndView modelAndView = new ModelAndView(JspPath.WATCHING_ACTIVITY_VIEW);
        String url = "https://www.youtube.com/embed/gQHddcdwDMQ";
        String nameAuthor = "Sergei Bragin";
        String nameActivity = "BAT METAL !!!!";
        String describe = "METAL IS LIVE !!!! ";

        modelAndView.addObject("URL", url);
        modelAndView.addObject("nameAuthor", nameAuthor);
        modelAndView.addObject("nameActivity", nameActivity);
        modelAndView.addObject("describe", describe);

        return modelAndView;
    }

}
