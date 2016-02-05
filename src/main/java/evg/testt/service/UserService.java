package evg.testt.service;

import evg.testt.model.User;

import java.util.List;

public interface UserService extends Service<User> {

    User getByEmail (String email);
}
