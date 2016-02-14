package evg.testt.dao;

import evg.testt.model.Chat;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatDao extends JpaRepository<Chat, Integer> {

    List<Chat> findByMessage(String message);

    List<Chat> findByUser(User user);

    List<Chat> findByUserEmail(String email);

}
