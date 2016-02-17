package evg.testt.model;

import javax.persistence.Entity;

@Entity(name = "level")
public class Level extends BaseModel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    private Integer difficult;




}
