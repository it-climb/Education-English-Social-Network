package evg.testt.util;


import evg.testt.model.Language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LanguageUtil {

    public static List<String> fillLanguages() {
        List<String> langs = new ArrayList<>();
        langs.add("English");
        langs.add("Ukranian");
        langs.add("Russian");
        langs.add("Frances");
        langs = Collections.unmodifiableList(langs);
        return langs;
    }

    public static Language defaultLangIn(String langIn) {
        Language languageIn = new Language();
        languageIn.setLanguageName(langIn);
        languageIn.setLanguageAtribute("");
        return languageIn;
    }

    public static Language defaultLangOut(String langOut) {
        Language languageOut = new Language();
        languageOut.setLanguageName(langOut);
        languageOut.setLanguageAtribute("");
        return languageOut;
    }

}
