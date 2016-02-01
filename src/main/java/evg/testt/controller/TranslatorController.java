package evg.testt.controller;

import evg.testt.dto.TranslatorDto;
import evg.testt.exception.TranslateServiceException;
import evg.testt.service.impl.translateserviceimpl.TranslateServiceImpl;
import evg.testt.service.translateservice.Language;
import evg.testt.service.translateservice.TranslateService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

@Controller
@RequestMapping(value = "translate")
public class TranslatorController {

    @Autowired
    TranslateService translateService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mainView() throws TranslateServiceException {
        ModelAndView modelAndView = new ModelAndView(JspPath.TRANSLATOR_HOME);
        TranslatorDto translatorDto = new TranslatorDto();
        Set<Language> languages = translateService.getAvailableLanguages();
        if (languages.size() > 1) {
            Iterator<Language> languageIterator = languages.iterator();
            translatorDto.setLanguageOut(languageIterator.next());
            translatorDto.setLanguageIn(languageIterator.next());
        } else {
            String errorMassage = "We can't do translating. Too less available languages for translating (less then two). Please try again later.";
            modelAndView.addObject("errorMassage", errorMassage);
            throw new TranslateServiceException("Too less available languages for translating (less then two).");
        }
        translatorDto.setLanguages(languages);
        translatorDto.setTextIn("This is the most perfect translator in the world I have ever seen!");
        modelAndView.addObject("translatorDto", translatorDto);
        return modelAndView;
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.GET)
    public String goMainView() {
        return "redirect:/translate";
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.POST)
    public ModelAndView doTranslate(String languageIn, String languageOut, String textIn) throws SQLException {
        TranslatorDto translatorDto = new TranslatorDto();
        translatorDto.setTextIn(textIn);
        Set<Language> languages = translateService.getAvailableLanguages();
        translatorDto.setLanguages(languages);
        for (Language language: languages) {
            if (language.getShortName().equals(languageIn)) {
                translatorDto.setLanguageIn(language);
            }
            if (language.getShortName().equals(languageOut)) {
                translatorDto.setLanguageOut(language);
            }
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
        try {
            translatorDto.setTextOut(translateService.translate(textIn,languageIn,languageOut).translation());
        } catch (TranslateServiceException e) {
            e.printStackTrace();
            String errorMassage = "We can't translate this text because you choose the same language! Please chose different language!";
            modelAndView.addObject("errorMassage", errorMassage);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
