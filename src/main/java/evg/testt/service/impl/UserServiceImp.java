package evg.testt.service.impl;

import evg.testt.util.MailMail;
import evg.testt.dao.UserDao;
import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImp extends BaseService<User, UserDao> implements UserService {

    @Autowired
    MailMail mailMail;

    @Override
    public User getByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public User insert(User o) throws SQLException{

            dao.save(o);
            mailMail.sendMail("from@no-spam.com",
                    o.getEmail(),
                    "Welcome list",
                    "Congratulation! \n\n Now you are in EESN team!");
            return o;


    }
}
