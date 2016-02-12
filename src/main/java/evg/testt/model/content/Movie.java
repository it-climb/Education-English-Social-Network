package evg.testt.model.content;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = Movie.COLLECTION_NAME)
public class Movie extends MovieContent<VideoFile> implements Serializable {

    public static final String COLLECTION_NAME = "movies";

    @Id
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
