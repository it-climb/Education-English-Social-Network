package evg.testt.service.impl;

import evg.testt.dao.UserDataDao;
import evg.testt.model.UserData;
import evg.testt.service.UserDataService;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl extends BaseService<UserData, UserDataDao> implements UserDataService{

}
