package evg.testt.service.impl;

import evg.testt.dao.UserDao;
import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends BaseService<User, UserDao> implements UserService {
}
