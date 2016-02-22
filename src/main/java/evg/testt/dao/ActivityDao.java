package evg.testt.dao;

import evg.testt.model.Activity;
import evg.testt.model.Chat;
import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, Integer> {
    Activity findByUser();
}
