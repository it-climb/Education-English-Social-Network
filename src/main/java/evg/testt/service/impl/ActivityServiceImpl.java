package evg.testt.service.impl;

import evg.testt.dao.ActivityDao;
import evg.testt.dao.ChatDao;
import evg.testt.model.Chat;
import evg.testt.model.Subject;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.service.ActivityService;
import evg.testt.service.ChatService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl extends BaseService<Activity, ActivityDao> implements ActivityService {

    /**
     * <p>It allows to get Page object with list of all Activities for required page from database</p>
     * <p>It useful for view entities with pagination</p>
     * @param pageable - Pageable request object with page number and number of Activities on
     *                 page information.
     * @return response Page object witch contains Activities for required page.
     */
    public Page<Activity> getAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    public List<Activity> getByAuthor(UserData userData){return dao.findByAuthor(userData);}

//    List<Activity> getByActivity(Subject subject){return dao.findByActivity(subject);}
}
