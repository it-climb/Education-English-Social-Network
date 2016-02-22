package evg.testt.dao;

import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, Integer> {
    List<Activity> findByAuthor(UserData author);
}
