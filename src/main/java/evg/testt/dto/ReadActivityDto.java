package evg.testt.dto;

import java.lang.reflect.Array;
import java.util.Set;

public class ReadActivityDto {

    private Array listOfSubj;

    private String name;

    private String text;

    public Array getListOfSubj() {
        return listOfSubj;
    }

    public void setListOfSubj(Array listOfSubj) {
        this.listOfSubj = listOfSubj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
