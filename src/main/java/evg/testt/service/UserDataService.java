package evg.testt.service;

import evg.testt.model.User;
import evg.testt.model.UserData;

public interface UserDataService extends Service<UserData>{
    UserData findByUser(User user);
}
