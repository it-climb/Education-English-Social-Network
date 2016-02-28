package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "knowledgeLevelPoints")
public class KnowledgeLevelPoints extends BaseModel {

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "user_id")
    private User user;

    private String subject = "someSubject";

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
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
