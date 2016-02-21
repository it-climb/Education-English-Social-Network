package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "activity")
public class Activity extends BaseModel {

    /**
     *  name of activity
     */
    protected String name;

    protected String targetAge;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "activity", fetch = FetchType.LAZY)
    private Set<SubjectInActivity> subjectInActivitySet;


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

        public Activity build() {
            return Activity.this;
        }
    }



}
