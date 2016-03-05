package evg.testt.model.activitycontent;

import java.util.List;

public class TestPassingActivityContent extends ActivityContent {

    private PassingTestData items;
//    private List<PassingTestData> items;

    private String magicString;

    public String getMagicString() {
        return magicString;
    }

    public void setMagicString(String magicString) {
        this.magicString = magicString;
    }

    public PassingTestData getItems() {
        return items;
    }

    public void setItems(PassingTestData items) {
        this.items = items;
    }
//    public List<PassingTestData> getItems() {
//        return items;
//    }
//
//    public void setItems(List<PassingTestData> items) {
//        this.items = items;
//    }
}
