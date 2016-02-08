package evg.testt.controller;

import evg.testt.model.Description;
import evg.testt.model.Word;
import evg.testt.service.DescriptionService;
import evg.testt.service.WordService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class DescriptionController {

    @Autowired
    WordService wordService;

    @Autowired
    DescriptionService descriptionService;

    @RequestMapping(value = "/description", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.DESCRIPTION_ALL);
        Word word = wordService.getById(id);
        modelAndView.addObject("word", word);
        modelAndView.addObject("descriptions", descriptionService.getByWord(word));
        return modelAndView;
    }

    @RequestMapping(value = "/descriptionSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute Description description, @RequestParam(required = true) Integer wordId) throws SQLException {
        Word word = wordService.getById(wordId);
        description.setWord(word);
        if(description.getId()!=null){
            descriptionService.insert(description);
        }else{
            descriptionService.update(description);
        }
        return "redirect:/word";
    }

    @RequestMapping(value = "/descriptionEdit", method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = false) Integer word_id, @RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.DESCRIPTION_EDIT);
        Description description;
        if(id!=null) {
            description = descriptionService.getById(id);
        }else{
            Word word = wordService.getById(word_id);
            description = Description.newBuilder().setWord(word).build();
        }
        modelAndView.addObject("description", description);
        return modelAndView;
    }

    @RequestMapping(value = "/descriptionDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Description description = descriptionService.getById(id);
        descriptionService.delete(description);
        return "redirect:/word";
    }


}
