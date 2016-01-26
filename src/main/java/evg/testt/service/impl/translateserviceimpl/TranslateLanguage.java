package evg.testt.service.impl.translateserviceimpl;

import evg.testt.service.translateservice.Language;

class TranslateLanguage implements Language {

    private final String shortName;

    private final String fullName;

    private final String englishNameOfLanguage;

    public TranslateLanguage(String shortName, String fullName, String englishNameOfLanguage) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.englishNameOfLanguage = englishNameOfLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranslateLanguage that = (TranslateLanguage) o;

        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        return fullName != null ? fullName.equals(that.fullName) : that.fullName == null
                && (englishNameOfLanguage != null ? englishNameOfLanguage.equals(that.englishNameOfLanguage)
                : that.englishNameOfLanguage == null);

    }

    @Override
    public int hashCode() {
        int result = shortName != null ? shortName.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (englishNameOfLanguage != null ? englishNameOfLanguage.hashCode() : 0);
        return result;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getEnglishNameOfLanguage() {
        return englishNameOfLanguage;
    }
}
