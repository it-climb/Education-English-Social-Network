package evg.testt.dao;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface KnowledgeLevelPointsDao extends JpaRepository<KnowledgeLevelPoints, Integer> {
    /**
     * <p>it allows to find in database all KnowledgeLevelPoints for given User</p>
     * @param user - search param
     * @return List of User KnowledgeLevelPoints
     */
    List<KnowledgeLevelPoints> findByUser(User user);

    /**
     * <p>it allows to find in database KnowledgeLevelPoints for given subject and User</p>
     * @param user - search param
     * @param subject - search param. Temporarily String, must be replaced to type Subject model
     * @return KnowledgeLevelPoints found by given subject and User
     */
    @Query("select klp from knowledgeLevelPoints klp where (klp.user = :user and klp.subject = :subject)")
    KnowledgeLevelPoints findByUserAndSubject(@Param("user") User user, @Param("subject") String subject);

}
