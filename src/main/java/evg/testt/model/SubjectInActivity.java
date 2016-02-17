package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by alex on 14.02.16.
 */
@Entity(name = "subjectInActivity")
public class SubjectInActivity extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @OneToOne
    @JoinColumn(name = "subjectid")
    private Subject subject;

}
