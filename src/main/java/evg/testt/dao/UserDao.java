package evg.testt.dao;

import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository<User, Integer> {

    //List<User> findByEmail (String email);
    User findByEmail (String email);

}
