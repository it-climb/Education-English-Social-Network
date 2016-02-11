package evg.testt.model.content;

import java.util.List;


public abstract class VideoContent<T> {

    private List<T> videoContent;
    private String describe;

    public List<T> getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(List<T> videoContent) {
        this.videoContent = videoContent;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
