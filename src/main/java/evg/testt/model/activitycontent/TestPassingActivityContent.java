package evg.testt.model.activitycontent;

import java.util.List;

public class TestPassingActivityContent extends ActivityContent {

    private List<PassingTestData> items;

    private String magicString;

    public String getMagicString() {
        return magicString;
    }

    public void setMagicString(String magicString) {
        this.magicString = magicString;
    }
}
