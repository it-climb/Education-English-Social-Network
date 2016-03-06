package evg.testt.service;

import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActivityCommonService extends Service<Activity>{
    List<Activity> findBySubjectName(String subjectName);

    Activity getActivityWithInnerActivitiesById(Integer id);
    Activity getActivityWithSubjectsInActivityById(Integer id);
    Activity getActivityWithAllValuesById(Integer id);

    /**
     * <p>It allows to get Page object with filtered by UserData list of all Activities</p>
     * <p>for required page from database</p>
     * <p>It useful for view entities with pagination</p>
     * @param author - UserData for request Activity list by User.
     * @param pageable - Pageable request object with page number and number of Activities on
     *                 page information.
     * @return response Page object witch contains filtered by given UserData Activities for required page.
     */
    Page<Activity> getActivityByAuthor(UserData author, Pageable pageable);
}
