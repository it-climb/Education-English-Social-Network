package evg.testt.model.activities;


import evg.testt.model.activitycontent.ReadingActivityContent;

public class ReadingActivity extends AbstractActivity  {
    private ReadingActivityContent content;

    public ReadingActivityContent getContent() {
        return content;
    }

    public void setContent(ReadingActivityContent content) {
        this.content = content;
    }
}
