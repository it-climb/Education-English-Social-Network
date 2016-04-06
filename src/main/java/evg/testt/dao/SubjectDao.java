package evg.testt.dao;

import evg.testt.model.Subject;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ReadingActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SubjectDao extends JpaRepository<Subject, Integer> {
    @Query("select sbj from subjects sbj where (sbj.name = :name)")
    Subject findByName(@Param("name") String name);

}
