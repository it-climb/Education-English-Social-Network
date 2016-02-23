package evg.testt.service;

import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;

import java.util.List;

public interface ActivityCommonService extends Service<Activity>{
    List<Activity> getActivityByAuthor(UserData author);
    Activity getActivityWithInnerActivitiesById(Integer id);
    Activity getActivityWithSubjectsInActivityById(Integer id);
    Activity getActivityWithAllValuesById(Integer id);
}
