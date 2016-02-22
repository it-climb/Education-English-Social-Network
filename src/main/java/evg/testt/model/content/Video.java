package evg.testt.model.content;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Video.COLLECTION_NAME)
public class Video extends VideoFile {

    public static final String COLLECTION_NAME = "videos";

    @Id
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
