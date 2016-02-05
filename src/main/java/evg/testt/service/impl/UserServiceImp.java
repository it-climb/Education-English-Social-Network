package evg.testt.service.impl;

import evg.testt.dao.UserDao;
import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends BaseService<User, UserDao> implements UserService {

    @Override
    public User getByEmail(String email) {
       return dao.findByEmail(email);
    }

}
