package evg.testt.dao;

import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, Integer> {
    List<Activity> findByAuthor(UserData author);

    //@Query("select activities from activities act where (klp.user = :user and klp.subject = :subject)")
    @Query("select a from activities a inner join knowledge_level_units inner join subjects subject on " +
            "knowledge_level_units.subject = subject and subject.name like :subject_name")
    List<Activity> findBySubjectName(@Param("subject_name") String subjectName);
}
