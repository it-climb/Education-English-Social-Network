package evg.testt.service;

import evg.testt.model.User;

import java.sql.SQLException;

public interface UserService extends Service<User> {

    User getByEmail (String email);

    @Override
    void insert(User o) throws SQLException;
}
