package evg.testt.dto;


import evg.testt.model.Language;

import java.util.Set;


public class TranslatorDto {

    private Language languageIn;
    private Language languageOut;
    private String textIn;
    private String textOut;
    Set<Language> languages;

    public Language getLanguageIn() { return languageIn; }

    public void setLanguageIn(Language languageIn) { this.languageIn = languageIn; }

    public Language getLanguageOut() { return languageOut; }

    public void setLanguageOut(Language languageOut) { this.languageOut = languageOut; }

    public Set<Language> getLanguages() {return languages;}

    public void setLanguages(Set<Language> languages) {this.languages = languages;}

    public String getTextIn() { return textIn; }

    public void setTextIn(String textIn) { this.textIn = textIn; }

    public String getTextOut() { return textOut; }

    public void setTextOut(String textOut) { this.textOut = textOut; }

}
