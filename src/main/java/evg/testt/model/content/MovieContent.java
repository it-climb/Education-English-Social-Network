package evg.testt.model.content;


import java.util.List;


public abstract class MovieContent<T> {

    private List<T> movieContent;
    private String describe;


    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<T> getMovieContent() {
        return movieContent;
    }

    public void setMovieContent(List<T> movieContent) {
        this.movieContent = movieContent;
    }

}
