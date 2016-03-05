package evg.testt.model;

import evg.testt.model.activities.Activity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "subjects")

public class Subject extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
