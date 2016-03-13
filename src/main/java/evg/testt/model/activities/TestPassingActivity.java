package evg.testt.model.activities;


import evg.testt.model.activitycontent.TestPassingActivityContent;

public class TestPassingActivity extends AbstractActivity {
    private TestPassingActivityContent content;

    public TestPassingActivityContent getContent() {
        return content;
    }

    public void setContent(TestPassingActivityContent content) {
        this.content = content;
    }
}
