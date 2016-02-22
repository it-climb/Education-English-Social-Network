package evg.testt.model.content;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = TvShow.COLLECTION_NAME)
public class TvShow extends SerialShowModel {

    public static final String COLLECTION_NAME = "tvshows";

    @Id
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
