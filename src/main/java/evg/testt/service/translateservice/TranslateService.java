package evg.testt.service.translateservice;

import java.util.Set;

public interface TranslateService {
    Set<Language> getAvailableLanguages();
    /*
    * @param textToTranslate - text in 'sourceLang' language
    * @param sourceLang - a short name of language (see ISO 639-1)
    * @param targetLang - a short name of language (see ISO 639-1)
    * @return TranslateResult
    * */
    TranslateResult translate(String textToTranslate, String sourceLang, String targetLang);

    TranslateResult translate(String textToTranslate, Language sourceLang, Language targetLang);
}
