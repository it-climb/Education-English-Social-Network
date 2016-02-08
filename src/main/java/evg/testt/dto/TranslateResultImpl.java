package evg.testt.dto;

import evg.testt.service.translateservice.TranslateResult;

import java.util.ArrayList;
import java.util.List;

public class TranslateResultImpl implements TranslateResult {

    private String translation;
    private String transcription = "";
    private String soundURL = "";

    private List<String> alternativeTranslations = new ArrayList<>();

    public void setAlternativeTranslations(List<String> alternativeTranslations) {
        this.alternativeTranslations = alternativeTranslations;
    }

    public void addAlternativeTranslations(String altTranslation) {
        alternativeTranslations.add(altTranslation);
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public void setSoundURL(String soundURL) {
        this.soundURL = soundURL;
    }

    @Override
    public String translation() {
        return translation;
    }

    @Override
    public String transcription() {
        return transcription;
    }

    @Override
    public String soundURL() {
        return soundURL;
    }

    @Override
    public List<String> alternativeTranslations() {
        return alternativeTranslations;
    }
}
