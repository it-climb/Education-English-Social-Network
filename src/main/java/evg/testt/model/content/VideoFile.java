package evg.testt.model.content;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.net.URL;


public class VideoFile {

    private String url;
    private String name;
    private String describe;
    private Integer serieNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSerieNumber() {
        return serieNumber;
    }

    public void setSerieNumber(Integer serieNumber) {
        this.serieNumber = serieNumber;
    }
}
