package evg.testt.controller;


import evg.testt.model.Word;
import evg.testt.service.WordService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class WordController
{
    @Autowired
    WordService wordService;

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public ModelAndView showAll() throws SQLException {
        return new ModelAndView(JspPath.WORD_ALL, "words", wordService.getAll());
    }

    @RequestMapping(value = "/wordSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = false) Integer id, @RequestParam(required = true) String name) throws SQLException {
        Word word = Word.newBuilder().setName(name).setId(id).build();
        if(id==null){
            wordService.insert(word);
        }else{
            wordService.update(word);
        }
        return "redirect:/word";
    }

    @RequestMapping(value = "/wordDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        wordService.delete(Word.newBuilder().setId(id).build());
        return "redirect:/word";
    }

    @RequestMapping(value = "/wordEdit", method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.WORD_EDIT);
        if(id!=null){
            Word word = wordService.getById(id);
            modelAndView.addObject("word", word);
        }
        return modelAndView;
    }
}
