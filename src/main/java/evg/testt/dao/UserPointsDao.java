package evg.testt.dao;

import evg.testt.model.UserAuthorshipPoints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointsDao  extends JpaRepository<UserAuthorshipPoints, Integer>{
}
