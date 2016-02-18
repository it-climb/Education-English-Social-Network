package evg.testt.service.impl.translateserviceimpl;

import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import evg.testt.dto.TranslateResultImpl;
import evg.testt.service.translateservice.TranslateResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TranslateServiceImplGoogleApi extends TranslateServiceImpl {

    @Override
    public TranslateResult translate(String textToTranslate, String sourceLang, String targetLang) throws GeneralSecurityException, IOException {
        TranslateResultImpl translateResult = new TranslateResultImpl();
        Translate t = new Translate.Builder(
                com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport()
                , com.google.api.client.json.gson.GsonFactory.getDefaultInstance(), null)
                .setApplicationName("EESN")
                .build();
        Translate.Translations.List list = t.new Translations().list(Arrays.asList(textToTranslate), targetLang);
        list.setSource(sourceLang);
        list.setKey("AIzaSyB5v0NsBr3XIvpySJZIBPQ3zEmJbRgDaeI");
        TranslationsListResponse response = list.execute();
        List<String> list1 = new ArrayList<>();
        for(TranslationsResource tr : response.getTranslations()) {
            list1.add(tr.getTranslatedText());
        }

        translateResult.setAlternativeTranslations(list1);


        return translateResult;

    }
}
