package evg.testt.service.impl;

import evg.testt.dao.ActivityDao;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.service.ActivityCommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    /**
     * <p>It allows to get Page object with filtered by UserData list of all Activities</p>
     * <p>for required page from database</p>
     * <p>It useful for view entities with pagination</p>
     * @param author - UserData for request Activity list by User.
     * @param pageable - Pageable request object with page number and number of Activities on
     *                 page information.
     * @return response Page object witch contains filtered by given UserData Activities for required page.
     */
    public Page<Activity> getActivityByAuthor(UserData author, Pageable pageable) {
        return dao.findByAuthor(author, pageable);
    }
}
