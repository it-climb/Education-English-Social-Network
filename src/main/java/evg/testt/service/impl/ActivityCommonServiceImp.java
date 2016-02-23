package evg.testt.service.impl;

import evg.testt.dao.ActivityDao;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.service.ActivityCommonService;

import java.util.List;

public class ActivityCommonServiceImp extends BaseService<Activity, ActivityDao> implements ActivityCommonService {

    @Override
    public List<Activity> getActivityByAuthor(UserData author) {
        return dao.findByAuthor(author);
    }

    @Override
    public Activity getActivityWithInnerActivitiesById(Integer id) {
        Activity activity = dao.findOne(id);
        activity.getInnerActivities().size();
        return activity;
    }

    @Override
    public Activity getActivityWithSubjectsInActivityById(Integer id) {
        Activity activity = dao.findOne(id);
        activity.getSubjectInActivitySet().size();
        return activity;
    }

    @Override
    public Activity getActivityWithAllValuesById(Integer id) {
        Activity activity = dao.findOne(id);
        activity.getInnerActivities().size();
        activity.getSubjectInActivitySet().size();
        return activity;
    }
}
