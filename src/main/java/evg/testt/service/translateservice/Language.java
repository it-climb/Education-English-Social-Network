package evg.testt.service.translateservice;

public interface Language {
    /*
    * for example: en - english, uk - ukrainian, ru - russian
    * @return ISO 639-1 Language Code
    * */
    String getShortName();

    /*
    * for example: en - english, uk - Українська, ru - русский
    * @return a native language name
    * */
    String getFullName();

    /*
    * for example: en - English, uk - Ukrainian, ru - Russian
    * @return a name of language in english
    * */
    String getEnglishNameOfLanguage();
}
