package evg.testt.controller;

import evg.testt.dto.TranslatorDto;
import evg.testt.service.translateservice.TranslateService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "translate")
public class TranslatorController {

    @Autowired
    TranslateService translateService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mainView() throws SQLException {
        TranslatorDto translatorDto = new TranslatorDto();
        //translatorDto.setLanguageIn(LanguageUtil.defaultLangIn("English"));
        //translatorDto.setLanguageOut(LanguageUtil.defaultLangOut("Ukranian"));
        translatorDto.setLanguages(translateService.getAvailableLanguages());
        translatorDto.setTextIn("This is the most perfect translator in the world I have ever seen!");
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.GET)
    public String goMainView() {
        return "redirect:/translate";
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.POST)
    public ModelAndView doTranslate(String languageIn, String languageOut, String textIn) throws SQLException {
        TranslatorDto translatorDto = new TranslatorDto();
        //translatorDto.setLanguageIn(LanguageUtil.defaultLangIn(languageIn));
        //translatorDto.setLanguageOut(LanguageUtil.defaultLangOut(languageOut));
        translatorDto.setTextIn(textIn);
        translatorDto.setLanguages(translateService.getAvailableLanguages());
        //Set<evg.testt.model.Language> languages = new HashSet<>(languageService.getAll());
        //translatorDto.setLanguages(languages);
        //translatorDto = translatorService.translate(translatorDto);
        try {
            translatorDto.setTextOut(translateService.translate(textIn,languageIn,languageOut).translation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
    }
}
