package evg.testt.dao;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import evg.testt.model.AuthorshipPoints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorshipPointsDao extends JpaRepository<AuthorshipPoints, Integer>{
    /**
     * <p>it allows to find in database AuthorshipPoints for given User</p>
     * @param user - search param
     * @return KnowledgeLevelPoints for given User
     */
    AuthorshipPoints findByUser(User user);
}
