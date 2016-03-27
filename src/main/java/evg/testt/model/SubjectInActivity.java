package evg.testt.model;

import evg.testt.model.activities.Activity;

import javax.persistence.*;

/**
 * Created by alex on 14.02.16.
 */
@Entity(name = "subjects_in_activity")
public class SubjectInActivity extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "difficult_level")
    @Enumerated(EnumType.STRING)
    private SubjectDifficult difficultLevel;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubjectDifficult getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(SubjectDifficult difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

}
