package evg.testt.service.impl;

import evg.testt.dao.UserDataDao;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.service.UserDataService;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl extends BaseService<UserData, UserDataDao> implements UserDataService{
    public UserData findByUser(User user) {
         UserData userData = dao.findByUser(user);
        if(userData != null) {
            return userData;
        }else{
            userData = new UserData();
            userData.setUser(user);
            dao.save(userData);
            return userData;
        }
    }
}
