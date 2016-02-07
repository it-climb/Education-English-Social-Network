package evg.testt.model;

import evg.testt.model.VideoContent;

import java.util.List;


public class CatalogVideoContent {

    List<VideoContent> serial;
    List<VideoContent> tvShows;
    VideoContent movie;

    public List<VideoContent> getSerial() {
        return serial;
    }

    public void setSerial(List<VideoContent> serial) {
        this.serial = serial;
    }

    public List<VideoContent> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<VideoContent> tvShows) {
        this.tvShows = tvShows;
    }

    public VideoContent getMovie() {
        return movie;
    }

    public void setMovie(VideoContent movie) {
        this.movie = movie;
    }
}
