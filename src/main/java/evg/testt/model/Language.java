package evg.testt.model;


import javax.persistence.Entity;

@Entity(name = "languages")
public class Language extends BaseModel {

    String languageName;
    String languageAtribute;

    public String getLanguageName() { return languageName; }

    public void setLanguageName(String languageName) { this.languageName = languageName; }

    public String getLanguageAtribute() { return languageAtribute; }

    public void setLanguageAtribute(String languageAtribute) { this.languageAtribute = languageAtribute; }


}
