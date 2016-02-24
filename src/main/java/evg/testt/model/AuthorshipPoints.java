package evg.testt.model;

import javax.persistence.*;


@Entity(name = "authorshipPoints")
public class AuthorshipPoints extends BaseModel {

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "user_id")
    private User user;

    private Integer authorshipPoints;

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

    /**
     *<p>it allows to increase User authorship points</p>
     * @param increment
     */
    public void increaseAuthorshipPoints(Integer increment) {
        authorshipPoints += increment;
    }
    /**
     *<p>it allows to decrease User authorship points</p>
     * @param decrement
     */
    public void decreaseAuthorshipPoints(Integer decrement) {
        authorshipPoints -= decrement;
    }


}
