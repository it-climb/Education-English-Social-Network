package evg.testt.model.activitycontent;

import evg.testt.model.Subject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Set;

@Document(collection = ActivityContent.COLLECTION_NAME)
public class ActivityContent implements Serializable {

    public static final String COLLECTION_NAME = "activityContents";

    @Id
    private Long id;

    private Set<Subject> subjects;

    public Set<Subject> getSubjects() {return subjects;}

    public void setSubjects(Set<Subject> subjects) {this.subjects = subjects;}

    public ActivityContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
