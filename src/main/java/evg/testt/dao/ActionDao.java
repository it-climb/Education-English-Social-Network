package evg.testt.dao;

import evg.testt.model.Actions;
import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ActionDao extends JpaRepository<Actions, Integer>{
}
