package evg.testt.model.activitycontent;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = ActivityContent.COLLECTION_NAME)
public class ActivityContent implements Serializable {

    public static final String COLLECTION_NAME = "activityContents";

    @Id
    private Long id;

    public ActivityContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
