package evg.testt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Document(collection = ObjectForComments.COLLECTION_NAME)
public class ObjectForComments {

    public static final String COLLECTION_NAME = "objectsForComments";

    @Id
    private Long id;

    private String className;

    private Long classId;

    private String comment;



    public ObjectForComments(){}

    public ObjectForComments(String className, Long classId, String comment) {
        this.className = className;
        this.classId = classId;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
