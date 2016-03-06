package evg.testt.service.impl;

import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.ReadingActivity;
import evg.testt.model.activities.WatchingActivity;
import evg.testt.model.activitycontent.ActivityContent;
import evg.testt.model.activitycontent.ReadingActivityContent;
import evg.testt.model.activitycontent.WatchingActivityContent;
import evg.testt.service.ActivityCommonService;
import evg.testt.service.ActivityContentService;
import evg.testt.service.ReadingActivityService;
import evg.testt.service.WatchingActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ReadingActivityServiceImpl implements ReadingActivityService {

    @Autowired
    private ActivityCommonService activityCommonService;

    @Autowired
    private ActivityContentService activityContentService;

    @Override
    public List<ReadingActivity> getAll() throws SQLException {
        return null;
    }

    @Override
    public ReadingActivity getById(Integer id) throws SQLException {
        Activity activity = activityCommonService.getById(id);
        ActivityContent activityContent = activityContentService.get(activity.getActivityContentId());

        if(!activity.getType().equals(ActivityType.READING_ACTIVITY)) {
            throw new SQLException("WatchingActivityServiceImpl: error activity type");
        }

        ReadingActivity readingActivity = new ReadingActivity();
        readingActivity.setActivity(activity);
        readingActivity.setContent((ReadingActivityContent) activityContent);

        return readingActivity;
    }

    @Override
    public void delete(ReadingActivity o) throws SQLException {
        activityCommonService.delete(o.getActivity());
        ActivityContent activityContent = o.getContent();
        activityContentService.remove(activityContent.getId());
    }

    @Override
    public ReadingActivity insert(ReadingActivity o) throws SQLException {
        activityCommonService.insert(o.getActivity());
        activityContentService.save(o.getContent());
        return o;
    }

    @Override
    public ReadingActivity update(ReadingActivity o) throws SQLException {
        activityCommonService.update(o.getActivity());
        activityContentService.save(o.getContent());
        return o;
    }
}
