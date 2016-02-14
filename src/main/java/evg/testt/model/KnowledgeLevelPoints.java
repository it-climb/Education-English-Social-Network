package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "knowledgeLevelPoints")
public class KnowledgeLevelPoints {

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "user_id")
    private User user;

    private Integer knowledgeLevelPoints;

    public Integer getKnowledgeLevelPoints() {
        return knowledgeLevelPoints;
    }

    public void setKnowledgeLevelPoints(Integer knowledgeLevelPoints) {
        this.knowledgeLevelPoints = knowledgeLevelPoints;
    }

    public void increaseKnowledgeLevel(Integer increment) {
        knowledgeLevelPoints += increment;
    }

    public String getSubject() {
        return "someSubject";
    }
    public void setSubject(String subject) {

    }

}
