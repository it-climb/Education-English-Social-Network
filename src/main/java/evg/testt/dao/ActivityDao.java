package evg.testt.dao;

import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ActivityDao extends JpaRepository<Activity, Integer> {
    List<Activity> findByAuthor(UserData author);

    Page<Activity> findAll(Pageable pageable);
//
//    List<Activity> findByAuthor(UserData author, Pageable pageable);
}
