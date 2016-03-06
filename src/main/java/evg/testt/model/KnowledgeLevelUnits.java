package evg.testt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "knowledge_level_units")
public class KnowledgeLevelUnits extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "level_units")
    private Integer levelUnits;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getLevelUnits() {
        return levelUnits;
    }

    public void setLevelUnits(Integer levelUnits) {
        this.levelUnits = levelUnits;
    }
}
