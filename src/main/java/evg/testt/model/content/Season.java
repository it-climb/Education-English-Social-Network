package evg.testt.model.content;

import java.util.List;


public abstract class Season<T> {

    private List<MovieContent<T>> season;
    private String describe;

    public List<MovieContent<T>> getSeason() {
        return season;
    }

    public void setSeason(List<MovieContent<T>> season) {
        this.season = season;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
