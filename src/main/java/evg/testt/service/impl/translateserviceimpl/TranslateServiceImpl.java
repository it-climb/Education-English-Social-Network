package evg.testt.service.impl.translateserviceimpl;

import evg.testt.dto.TranslateLanguage;
import evg.testt.dto.TranslateResultImpl;
import evg.testt.exception.translateexceptions.EmptyFieldException;
import evg.testt.exception.translateexceptions.TheSameLanguageException;
import evg.testt.exception.translateexceptions.TranslateServiceException;
import evg.testt.service.translateservice.Language;
import evg.testt.service.translateservice.TranslateResult;
import evg.testt.service.translateservice.TranslateService;
import org.apache.http.HttpEntity;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;


@Service
public class TranslateServiceImpl implements TranslateService {

    private static final TranslateLanguage LANG_ENGLISH_EN = new TranslateLanguage("en","english","english");
    private static final TranslateLanguage LANG_RUSSIAN_RU = new TranslateLanguage("ru","русский","russian");

    private static final Set<Language> availableLanguages = new HashSet<>();

    private static final JSONParser parser = new JSONParser();

    static {
        availableLanguages.add(LANG_ENGLISH_EN);
        availableLanguages.add(LANG_RUSSIAN_RU);
    }

    private static final String FMT_PREPARED_TRANSLATE_SERVICE_URL_MAIN
            = "http://api.lingualeo.com/translate.php?q=%s&source=%s&target=%s&port=1001";

    private static final String FMT_PREPARED_TRANSLATE_SERVICE_URL_ADDITION
            = "http://api.lingualeo.com/gettranslates?word=%s";

    private final CacheConfig cacheConfig = CacheConfig.custom()
            .setMaxCacheEntries(1000)
            .setMaxObjectSize(8192)
            .build();
    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30000)
            .setSocketTimeout(30000)
            .build();
    private final CloseableHttpClient cachingClient = CachingHttpClients.custom()
            .setCacheConfig(cacheConfig)
            .setDefaultRequestConfig(requestConfig)
            .build();
    private final HttpCacheContext context = HttpCacheContext.create();

    private class TranslateParams {
        private final String textToTranslate;
        private final String sourceLang;
        private final String targetLang;

        public TranslateParams(String textToTranslate, String sourceLang, String targetLang) {
            this.textToTranslate = textToTranslate;
            this.sourceLang = sourceLang;
            this.targetLang = targetLang;
        }

        public String getTextToTranslate() {
            return textToTranslate;
        }

        public String getSourceLang() {
            return sourceLang;
        }

        public String getTargetLang() {
            return targetLang;
        }
    }


    @Override
    public Set<Language> getAvailableLanguages() {
        return Collections.unmodifiableSet(availableLanguages);
    }

    private String executeRequest(URI url) throws IOException {

        HttpGet httpget = new HttpGet(url);

        try (CloseableHttpResponse response = cachingClient.execute(httpget, context)) {
            HttpEntity entity;
            if (response.getStatusLine().getStatusCode() == 200) {
                entity = response.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    return encodingStringToUTF8(entity);
                }
            }
        }
        return "";
    }

    private URI buildTranslateServiceMainUri(TranslateParams translateParams) throws URISyntaxException {
        return new URIBuilder()
                .setScheme("http")
                .setHost("api.lingualeo.com")
                .setPath("/translate.php")
                .setParameter("q", translateParams.getTextToTranslate())
                .setParameter("source", translateParams.getSourceLang())
                .setParameter("target", translateParams.getTargetLang())
                .setParameter("port", "1001")
                .build();
    }

    private URI buildTranslateServiceAdditionUri(TranslateParams translateParams) throws URISyntaxException {
        return new URIBuilder()
                .setScheme("http")
                .setHost("api.lingualeo.com")
                .setPath("/gettranslates")
                .setParameter("word", translateParams.getTextToTranslate())
                .build();
    }

    private TranslateResultImpl executeAndProcessResponseForMainURL(TranslateParams translateParams)
            throws TranslateServiceException {
        try {
            return parseMainTranslateResultFromJson(executeRequest(buildTranslateServiceMainUri(translateParams)));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new TranslateServiceException(e);
        }
    }

    @Override
    public TranslateResult translate(String textToTranslate, String sourceLang, String targetLang) {
        TranslateResultImpl translateResult;
        if (textToTranslate.isEmpty()) {
            throw new EmptyFieldException("No data to translate. Please fill expression for translating.");
        } else if (sourceLang.equals(targetLang)) {
            throw new TheSameLanguageException("We can't translate this text because you choose the same language!" +
                    " Please chose different language!");
        } else {
            TranslateParams translateParams = new TranslateParams(textToTranslate,sourceLang,targetLang);
            translateResult = executeAndProcessResponseForMainURL(translateParams);

            if(sourceLang.equals(LANG_ENGLISH_EN.getShortName()) && targetLang.equals(LANG_RUSSIAN_RU.getShortName())) {
                TranslateResultImpl additionTranslateResult = executeAndProcessResponseForAddURL(translateParams);
                updateTranslateResult(translateResult,additionTranslateResult);
            }
        }
        return translateResult;
    }

    private void updateTranslateResult(TranslateResultImpl translateResult, TranslateResultImpl additionTranslateResult) {
        translateResult.setSoundURL(additionTranslateResult.soundURL());
        translateResult.setTranscription(additionTranslateResult.transcription());
        translateResult.addAlternativeTranslations(additionTranslateResult.translation());
        translateResult.setAlternativeTranslations(additionTranslateResult.alternativeTranslations());
    }

    @Override
    public TranslateResult translate(String textToTranslate, Language sourceLang, Language targetLang) {
        return translate(textToTranslate, sourceLang.getShortName(), targetLang.getShortName());
    }

    private TranslateResultImpl executeAndProcessResponseForAddURL(TranslateParams translateParams) {
        try {
            return parseAdditionTranslateResultFromJson(executeRequest(buildTranslateServiceAdditionUri(translateParams)));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new TranslateServiceException(e);
        }
    }

    private String encodingStringToUTF8(HttpEntity entity) throws IOException {
        return new String(EntityUtils.toByteArray(entity), Charset.forName("UTF-8"));
    }


    @SuppressWarnings("unchecked")
    private TranslateResultImpl parseAdditionTranslateResultFromJson(String json) {
        try {
            Map<String,Object> resultMap = (Map<String,Object>) parser.parse(json);

            List<Map<String,Object>> translation = (List<Map<String,Object>>) resultMap.get("translate");

            if(translation == null) {
                throw new TranslateServiceException("Can't translate!");
            }

            List<String> allListTranslations = new ArrayList<>();

            for(Map<String,Object> translateValue : translation) {
                String value = (String) translateValue.get("value");
                if(value != null) {
                    allListTranslations.add(value);
                }
            }

            if(allListTranslations.isEmpty()) {
                throw new TranslateServiceException("Can't translate!");
            }

            TranslateResultImpl translateResult = new TranslateResultImpl();
            translateResult.setTranslation(allListTranslations.get(0));

            for(int i = 1; i < allListTranslations.size(); i++) {
                translateResult.addAlternativeTranslations(allListTranslations.get(i));
            }

            String tmpString = (String) resultMap.get("transcription");
            if(tmpString != null) {
                translateResult.setTranscription(tmpString);
            }

            tmpString = (String) resultMap.get("sound_url");
            if(tmpString != null) {
                translateResult.setSoundURL(tmpString);
            }

            return translateResult;

        } catch (ParseException e) {
            e.printStackTrace();
            throw new TranslateServiceException("ParseException");
        }
    }

    @SuppressWarnings("unchecked")
    private TranslateResultImpl parseMainTranslateResultFromJson(String json) throws TranslateServiceException {
        try {
            Map<String,String> resultMap = (Map<String,String>) parser.parse(json);

            String translation = resultMap.get("translation");

            if(translation == null) {
                throw new TranslateServiceException("Can't translate!");
            }

            TranslateResultImpl translateResult = new TranslateResultImpl();
            translateResult.setTranslation(translation);

            return translateResult;

        } catch (ParseException e) {
            e.printStackTrace();
            throw new TranslateServiceException("ParseException");
        }
    }
}
