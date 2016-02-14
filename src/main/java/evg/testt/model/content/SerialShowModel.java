package evg.testt.model.content;

import java.util.List;


public abstract class SerialShowModel {

    private List<Season> season;
    private String name;
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Season> getSeason() {
        return season;
    }

    public void setSeason(List<Season> season) {
        this.season = season;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
