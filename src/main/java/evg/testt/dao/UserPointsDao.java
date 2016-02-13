package evg.testt.dao;

import evg.testt.model.UserPoints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointsDao  extends JpaRepository<UserPoints, Integer>{
}
