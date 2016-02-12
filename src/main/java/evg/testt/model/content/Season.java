package evg.testt.model.content;

import java.util.List;


public abstract class Season {

    private List<MovieContent> season;
    private String name;
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieContent> getSeason() {
        return season;
    }

    public void setSeason(List<MovieContent> season) {
        this.season = season;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
