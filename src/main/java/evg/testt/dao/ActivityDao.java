package evg.testt.dao;

import evg.testt.model.SubjectDifficult;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("select a from activities a where a.id in " +
            "(select sa.activity_id from subjects_in_activity sa where " +
            "sa.subject_id in :subjectIDs and sa.difficult_level in :difficultLevels ) and " +
            "a.name like concat('%', :searchPhrase, '%') and a.type in :types and " +
            "a.targetAge in :targetAges ")
    Page<Activity> findBySearchFilter(Pageable pageRequest,
                                      @Param("subjectIDs") List<Integer> subjectIDs,
                                      @Param("difficultLevels") List<SubjectDifficult> difficultLevels,
                                      @Param("searchPhrase") String searchPhrase,
                                      @Param("types") List<ActivityType> types,
                                      @Param("targetAges") List<String> targetAges);

}
