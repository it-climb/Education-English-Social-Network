package evg.testt.model.activities;

import evg.testt.model.activitycontent.WatchingActivityContent;

public class WatchingActivity extends AbstractActivity  {
    private WatchingActivityContent content;

    public WatchingActivityContent getContent() {
        return content;
    }

    public void setContent(WatchingActivityContent content) {
        this.content = content;
    }
}
