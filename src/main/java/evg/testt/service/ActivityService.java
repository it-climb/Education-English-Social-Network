package evg.testt.service;

import evg.testt.model.Chat;
import evg.testt.model.User;
import evg.testt.model.activities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActivityService extends Service<Activity> {
    Page<Activity> getAll(Pageable pageable);
}
