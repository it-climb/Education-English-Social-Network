package evg.testt.controller;

import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import evg.testt.dto.TranslatorDto;
import evg.testt.exception.translateexceptions.EmptyFieldException;
import evg.testt.exception.translateexceptions.TheSameLanguageException;
import evg.testt.exception.translateexceptions.TranslateServiceException;
import evg.testt.service.translateservice.Language;
import evg.testt.service.translateservice.TranslateService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

@Controller
//@RequestMapping(value = "translate")
public class TranslatorController {

    @Autowired
    TranslateService translateService;


    @RequestMapping(value = "/translate", method = RequestMethod.GET)
//    @RequestMapping(value = "", method = RequestMethod.GET)
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
            translatorDto.setTextOut(translateService.translate(textIn, languageIn, languageOut).translation());
        } catch (EmptyFieldException e) {
            String errorMassage = "You ";
            modelAndView.addObject("errorMassage", errorMassage);
            e.printStackTrace();
        } catch (TheSameLanguageException e) {
            String errorMassage = "The source and target language are same. Please, change one of them.";
            modelAndView.addObject("errorMassage", errorMassage);
            e.printStackTrace();
        } catch (TranslateServiceException e) {
            String errorMassage = "We can't translate this expression. Please try change your query.";
            modelAndView.addObject("errorMassage", errorMassage);
            e.printStackTrace();
        } catch (Exception e) {
            String errorMassage = e.getMessage();
            modelAndView.addObject("errorMassage", errorMassage);
            e.printStackTrace();
        }
        return modelAndView;
    }
}
