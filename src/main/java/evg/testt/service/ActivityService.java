package evg.testt.service;

import evg.testt.model.Chat;
import evg.testt.model.Subject;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActivityService extends Service<Activity> {

    /**
     * <p>It allows to get Page object with list of all Activities for required page from database</p>
     * <p>It useful for view entities with pagination</p>
     * @param pageable - Pageable request object with page number and number of Activities on
     *                 page information.
     * @return response Page object witch contains Activities for required page.
     */
    Page<Activity> getAll(Pageable pageable);

    List<Activity> getByAuthor(UserData userData);

//    List<Activity> getByActivity(Subject subject);
}
