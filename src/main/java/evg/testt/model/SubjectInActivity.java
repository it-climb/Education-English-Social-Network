package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by alex on 14.02.16.
 */
@Entity(name = "subjectInActivity")
public class SubjectInActivity extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "subjectid")
    private Subject subject;

}
