package evg.testt.service.impl.translateserviceimpl;

import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import evg.testt.dto.TranslateResultImpl;
import evg.testt.exception.translateexceptions.TranslateServiceException;
import evg.testt.service.translateservice.TranslateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@ComponentScan(basePackages = { "evg.testt*" })
@PropertySource("classpath:config.properties")
@Service
public class TranslateServiceImplGoogleApi extends TranslateServiceImpl {

//    Properties properties = new Properties();

    @Autowired
    private Environment env;


    @Override
    public TranslateResult translate(String textToTranslate, String sourceLang, String targetLang) throws IOException {
        TranslateResultImpl translateResult = new TranslateResultImpl();
        Translate t = null;
        Translate.Translations.List list = null;
        try {
//            File file = new File("config.properties");
//            FileReader reader = new FileReader(file);
//            properties.load(reader);
//            InputStream inputStream = new FileInputStream("/config.properties");
//
//            if (inputStream != null){
//                properties.load(inputStream);
//            }
//            fileInputStream = new FileInputStream("EESN/Education-English-Social-Network/src/main/resources/config.properties");
//            properties.load(fileInputStream);
            t = new Translate.Builder(
                    com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport()
                    , com.google.api.client.json.gson.GsonFactory.getDefaultInstance(), null)
                    .setApplicationName(env.getProperty("appName"))
                    .build();
            list = t.new Translations().list(Arrays.asList(textToTranslate), targetLang);
//        list.setSource(sourceLang);
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

        translateResult.setTranslation(list1.get(0));
        list1.remove(0);
        translateResult.setAlternativeTranslations(list1);

        return translateResult;

    }
}
