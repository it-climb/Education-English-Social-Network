package evg.testt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Document(collection = Comment.COLLECTION_NAME)
@Entity(name = "comments")
public class Comment {

    public static final String COLLECTION_NAME = "comments";

    @ManyToOne
    @JoinColumn(name = "objectForComment_id")
    private ObjectForComments objectForComments;

    @Id
    private Long id;

    private String message;
    private LocalDate data;
    private String userAcc;

    public Comment() {

    }

    public Comment(String message, String userAcc) {
        this.message = message;
        this.userAcc = userAcc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjectForComments getObjectForComments() {
        return objectForComments;
    }

    public void setObjectForComments(ObjectForComments objectForComments) {
        this.objectForComments = objectForComments;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }
}
