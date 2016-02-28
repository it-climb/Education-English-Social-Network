package evg.testt.model;

import javax.persistence.*;

/**
 * Created by alex on 14.02.16.
 */
@Entity(name = "subjects_in_activity")
public class SubjectInActivity extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "difficult_level")
    @Enumerated(EnumType.STRING)
    private SubjectDifficult difficultLevel;
}
