package evg.testt.model;

import javax.persistence.*;


@Entity(name = "UserPoints")
public class UserAuthorshipPoints extends BaseModel {

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "user_id")
    private User user;


    private Integer knowledgeLevelPoints;

    private Integer authorshipPoints;


    public Integer getKnowledgeLevelPoints() {
        return knowledgeLevelPoints;
    }

    public void setKnowledgeLevelPoints(Integer knowledgeLevelPoints) {
        this.knowledgeLevelPoints = knowledgeLevelPoints;
    }

    public Integer getAuthorshipPoints() {
        return authorshipPoints;
    }

    public void setAuthorshipPoints(Integer authorshipPoints) {
        this.authorshipPoints = authorshipPoints;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void increaseKnowledgeLevel(Integer increment) {
        knowledgeLevelPoints += increment;
    }
    public void decreaseKnowledgeLevel(Integer decrement) {
        knowledgeLevelPoints -= decrement;
    }

    public void increaseAuthorshipPoints(Integer increment) {
        authorshipPoints += increment;
    }
    public void decreaseAuthorshipPoints(Integer decrement) {
        authorshipPoints -= decrement;
    }


}
