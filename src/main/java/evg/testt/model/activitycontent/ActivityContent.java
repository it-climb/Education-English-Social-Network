package evg.testt.model.activitycontent;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "activityContents")
public class ActivityContent implements Serializable {
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
