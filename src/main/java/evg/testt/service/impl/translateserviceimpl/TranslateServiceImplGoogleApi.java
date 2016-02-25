package evg.testt.service.impl.translateserviceimpl;

import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import evg.testt.dto.TranslateResultImpl;
import evg.testt.exception.translateexceptions.TheSameLanguageException;
import evg.testt.exception.translateexceptions.TranslateServiceException;
import evg.testt.service.translateservice.Language;
import evg.testt.service.translateservice.TranslateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;
@Service
@ComponentScan(basePackages = { "evg.testt*" })
@PropertySource("classpath:config.properties")
public class TranslateServiceImplGoogleApi extends TranslateServiceImpl {

    @Autowired
    private Environment env;

    @Override
    public TranslateResult translate(String textToTranslate, String sourceLang, String targetLang) throws IOException {


        TranslateResultImpl translateResult = new TranslateResultImpl();
        Translate t = null;
        Translate.Translations.List list = null;
        try {
            t = new Translate.Builder(
                    com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport()
                    , com.google.api.client.json.gson.GsonFactory.getDefaultInstance(), null)
                    .setApplicationName(env.getProperty("appName"))
                    .build();
            list = t.new Translations().list(Arrays.asList(textToTranslate), targetLang);
            list.setKey(env.getProperty("appPassKey"));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new TranslateServiceException();
        }

        TranslationsListResponse response = list.execute();
        List<String> list1 = new ArrayList<>();
        for(TranslationsResource tr : response.getTranslations()) {
            list1.add(tr.getTranslatedText());
        }

        Set<Language> language = getAvailableLanguages();
        for (Language l : language){
            if (l.getShortName().equals(sourceLang)) {
                if (textToTranslate.isEmpty()) {
                    throw new EmptyStackException();
                } else {
                    if (sourceLang.equals(targetLang)) {
                        throw new TheSameLanguageException();
                    } else {

                if (response.getTranslations().get(0).getDetectedSourceLanguage().equals(l.getShortName())) {
                    translateResult.setTranslation(list1.get(0));
                    list1.remove(0);
                    translateResult.setAlternativeTranslations(list1);

                }
                else {

                            throw new TranslateServiceException();
                        }
                    }
                }
            }

        }
        return translateResult;
    }
}
