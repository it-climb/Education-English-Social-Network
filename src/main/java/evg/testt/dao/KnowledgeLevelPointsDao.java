package evg.testt.dao;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface KnowledgeLevelPointsDao extends JpaRepository<KnowledgeLevelPoints, Integer> {
    List<KnowledgeLevelPoints> findByUser(User user);

    @Query("select klp from knowledgeLevelPoints klp where (klp.user = :user and klp.subject = :subject)")
    KnowledgeLevelPoints findByUserAndSubject(@Param("user") User user, @Param("subject") String subject);

}
