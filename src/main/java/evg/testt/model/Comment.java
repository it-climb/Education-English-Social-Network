package evg.testt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;

@Document(collection = Comment.COLLECTION_NAME)
public class Comment {

    public static final String COLLECTION_NAME = "comments";

    @Id
    private Long id;

    private String objectForComments;
    private Data data;
    private String userAcc;

    public Comment() {
    }

    public Comment(String objectForComments, Data data, String userAcc) {
        this.objectForComments = objectForComments;
        this.data = data;
        this.userAcc = userAcc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectForComments() {
        return objectForComments;
    }

    public void setObjectForComments(String objectForComments) {
        this.objectForComments = objectForComments;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }
}
