package evg.testt.service.impl;

import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.TestPassingActivity;
import evg.testt.model.activitycontent.ActivityContent;
import evg.testt.model.activitycontent.TestPassingActivityContent;
import evg.testt.service.ActivityCommonService;
import evg.testt.service.ActivityContentService;
import evg.testt.service.PassingTestActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PassingTestAvtivityServiceImpl implements PassingTestActivityService {

    @Autowired
    private ActivityCommonService activityCommonService;

    @Autowired
    private ActivityContentService activityContentService;


    @Override
    public List<TestPassingActivity> getAll() throws SQLException {
        return null;
    }

    @Override
    public TestPassingActivity getById(Integer id) throws SQLException {

        Activity activity = activityCommonService.getById(id);
        ActivityContent activityContent = activityContentService.get(activity.getActivityContentId());

        if(!activity.getType().equals(ActivityType.PASSING_TEST_ACTIVITY)){
            throw new SQLException("PassingTestActivityServiceImpl: error activity type");
        }

        TestPassingActivity passingActivity = new TestPassingActivity();
        passingActivity.setActivity(activity);
        passingActivity.setContent((TestPassingActivityContent) activityContent);

        return passingActivity;
    }

    @Override
    public void delete(TestPassingActivity o) throws SQLException {
        activityCommonService.delete(o.getActivity());
        ActivityContent activityContent = o.getContent();
        activityContentService.remove(activityContent.getId());
    }

    @Override
    public TestPassingActivity insert(TestPassingActivity o) throws SQLException {
        ActivityContent content = activityContentService.save(o.getContent());
        Activity activity = o.getActivity();
        activity.setActivityContentId(content.getId());
        activityCommonService.insert(activity);
        return o;
    }

    @Override
    public TestPassingActivity update(TestPassingActivity o) throws SQLException {
        activityCommonService.update(o.getActivity());
        activityContentService.save(o.getContent());
        return o;
    }
}
