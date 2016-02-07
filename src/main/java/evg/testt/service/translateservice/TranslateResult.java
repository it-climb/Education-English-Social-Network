package evg.testt.service.translateservice;

import java.util.List;

public interface TranslateResult {
    String translation();
    /*
    * Now a transcription returns only for english words. for other languages it may returns an empty result.
    * @return transcription
    * */
    String transcription();

    /*
    * Now a soundURL returns only for english words. for other languages it may returns an empty result.
    * @return soundURL
    * */
    String soundURL();

    /*
    * Now alternative translations returns only for english words. for other languages it may returns an empty result.
    * @return a list (String) of alternative translations
    * */
    List<String> alternativeTranslations();
}
