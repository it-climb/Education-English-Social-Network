package evg.testt.dao;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import evg.testt.model.AuthorshipPoints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorshipPointsDao extends JpaRepository<AuthorshipPoints, Integer>{
    AuthorshipPoints findByUser(User user);
}
