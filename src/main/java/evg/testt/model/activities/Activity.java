package evg.testt.model.activities;

import evg.testt.model.BaseModel;
import evg.testt.model.KnowledgeLevelUnits;
import evg.testt.model.SubjectInActivity;
import evg.testt.model.UserData;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "activities")
public class Activity extends BaseModel {

    /**
     *  name of activity
     */
    protected String name;

    protected String targetAge;

    @Column(name = "activity_content_id")
    protected Long activityContentId;

    @Column(name = "activity_type")
    @Enumerated(EnumType.STRING)
    protected ActivityType type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Set<KnowledgeLevelUnits> knowledgeLevelUnitsSet;

    @ManyToOne
    @JoinColumn(name = "user_data_id")
    private UserData author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_that_are_finished_activitiy",
            joinColumns = @JoinColumn(name = "activity_pk"),
            inverseJoinColumns = @JoinColumn(name = "user_fk"))
    private Set<UserData> usersThatAreFinishedActivity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "inner_activities",
        joinColumns = @JoinColumn(name = "activity_pk"),
        inverseJoinColumns = @JoinColumn(name = "activity_fk"))
    private Set<Activity> innerActivities;


    public Set<UserData> getUsersThatAreFinishedActivity() {
        return usersThatAreFinishedActivity;
    }

    public void setUsersThatAreFinishedActivity(Set<UserData> usersThatAreFinishedActivity) {
        this.usersThatAreFinishedActivity = usersThatAreFinishedActivity;
    }

    public Long getActivityContentId() {
        return activityContentId;
    }

    public void setActivityContentId(Long activityContentId) {
        this.activityContentId = activityContentId;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public Set<KnowledgeLevelUnits> getKnowledgeLevelUnitsSet() {
        return knowledgeLevelUnitsSet;
    }

    public void setKnowledgeLevelUnitsSet(Set<KnowledgeLevelUnits> knowledgeLevelUnitsSet) {
        this.knowledgeLevelUnitsSet = knowledgeLevelUnitsSet;
    }

    public Set<Activity> getInnerActivities() {
        return innerActivities;
    }

    public void setInnerActivities(Set<Activity> innerActivities) {
        this.innerActivities = innerActivities;
    }

    public UserData getAuthor() {
        return author;
    }

    public void setAuthor(UserData author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(String targetAge) {
        this.targetAge = targetAge;
    }

    public static Builder newBuilder() {
        return new Activity().new Builder();
    }

    public class Builder {

        private Builder() {
        }


        public Builder setName(String name) {
            Activity.this.name = name;

            return this;
        }

        public Builder setTargetAge(String targetAge) {
            Activity.this.targetAge = targetAge;

            return this;
        }

        public Builder setAuthor(UserData author) {
            Activity.this.author = author;

            return this;
        }

        public Builder setActivityType(ActivityType type) {
            Activity.this.type = type;

            return this;
        }

        public Activity build() {
            return Activity.this;
        }
    }



}
