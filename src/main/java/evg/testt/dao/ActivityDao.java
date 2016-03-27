package evg.testt.dao;

import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.Subject;
import java.util.List;

@Transactional(readOnly = true)
public interface ActivityDao extends JpaRepository<Activity, Integer> {
    List<Activity> findByAuthor(UserData author);

    /**
     * <p>It allows to get Page object with list of all Activities for required page from database</p>
     * <p>It useful for view entities with pagination</p>
     * @param pageable - Pageable request object with page number and number of Activities on
     *                 page information.
     * @return response Page object witch contains Activities for required page.
     */
    Page<Activity> findAll(Pageable pageable);

    /**
     * <p>It allows to get Page object with filtered by UserData list of all Activities</p>
     * <p>for required page from database</p>
     * <p>It useful for view entities with pagination</p>
     * @param author - UserData for request Activity list by User.
     * @param pageable - Pageable request object with page number and number of Activities on
     *                 page information.
     * @return response Page object witch contains filtered by given UserData Activities for required page.
     */
    Page<Activity> findByAuthor(UserData author, Pageable pageable);

    //@Query("select activities from activities act where (klp.user = :user and klp.subject = :subject)")
    //@Query("select a from activities a inner join knowledge_level_units inner join subjects subject on " +
    //        "knowledge_level_units.subject = subject and subject.name like :subject_name")

    @Query("select a from activities a, knowledge_level_units k, subjects s where " +
                    "k.subject = s and s.name like :subject_name")
    List<Activity> findBySubjectName(@Param("subject_name") String subjectName);

//    Page<Activity> findByActivity(Subject subject);


}
