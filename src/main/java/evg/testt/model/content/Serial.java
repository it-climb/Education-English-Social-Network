package evg.testt.model.content;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Serial.COLLECTION_NAME)
public class Serial extends Season{

    public static final String COLLECTION_NAME = "serials";

    @Id
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
