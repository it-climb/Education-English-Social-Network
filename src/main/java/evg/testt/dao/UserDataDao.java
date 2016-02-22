package evg.testt.dao;


import evg.testt.model.User;
import evg.testt.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataDao extends JpaRepository<UserData, Integer>{
    UserData findByUser(User user);
}
