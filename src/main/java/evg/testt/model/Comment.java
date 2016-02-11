package evg.testt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = Comment.COLLECTION_NAME)
public class Comment {

    public static final String COLLECTION_NAME = "comments";

    @Id
    private Long id;

    private String className;
    private Long classId;
    private LocalDate data;
    private String comment;

    public Comment() {

    }

    public Comment(String className, Long classId, String comment) {
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
