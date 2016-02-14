package evg.testt.dao;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KnowledgeLevelPointsDao extends JpaRepository<KnowledgeLevelPoints, Integer> {
    List<KnowledgeLevelPoints> findByUser(User user);
}
