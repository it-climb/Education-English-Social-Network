package evg.testt.service.impl;

import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.WatchingActivity;
import evg.testt.model.activitycontent.ActivityContent;
import evg.testt.model.activitycontent.WatchingActivityContent;
import evg.testt.service.ActivityCommonService;
import evg.testt.service.ActivityContentService;
import evg.testt.service.WatchingActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class WatchingActivityServiceImpl implements WatchingActivityService {

    @Autowired
    private ActivityCommonService activityCommonService;

    @Autowired
    private ActivityContentService activityContentService;

    @Override
    public List<WatchingActivity> getAll() throws SQLException {
        return null;
    }

    @Override
    public WatchingActivity getById(Integer id) throws SQLException {
        Activity activity = activityCommonService.getById(id);
        ActivityContent activityContent = activityContentService.get(activity.getActivityContentId());

        if(!activity.getType().equals(ActivityType.WATCHING_ACTIVITY)) {
            throw new SQLException("WatchingActivityServiceImpl: error activity type");
        }

        WatchingActivity watchingActivity = new WatchingActivity();
        watchingActivity.setActivity(activity);
        watchingActivity.setContent((WatchingActivityContent) activityContent);

        return watchingActivity;
    }

    @Override
    public void delete(WatchingActivity o) throws SQLException {
        activityCommonService.delete(o.getActivity());
        ActivityContent activityContent = o.getContent();
        activityContentService.remove(activityContent.getId());
    }

    @Override
    public WatchingActivity insert(WatchingActivity o) throws SQLException {
        activityCommonService.insert(o.getActivity());
        activityContentService.save(o.getContent());
        return o;
    }

    @Override
    public WatchingActivity update(WatchingActivity o) throws SQLException {
        activityCommonService.update(o.getActivity());
        activityContentService.save(o.getContent());
        return o;
    }
}
