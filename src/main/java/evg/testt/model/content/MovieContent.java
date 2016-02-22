package evg.testt.model.content;


import java.util.List;


public abstract class MovieContent<T> {

    private List<T> listVideoFiles;
    private String describe;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<T> getListVideoFiles() {
        return listVideoFiles;
    }

    public void setListVideoFiles(List<T> listVideoFiles) {
        this.listVideoFiles = listVideoFiles;
    }
}
