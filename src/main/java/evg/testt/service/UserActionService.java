package evg.testt.service;


import evg.testt.dao.SequenceDao;
import evg.testt.dao.UserActionDao;
import evg.testt.model.userActionModels.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionService {

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    private UserActionDao userActionDao;

    public void save(UserAction userAction){
        if(userAction.getId() == null) {
            userAction.setId(sequenceDao.getNextSequenceId(userAction.ACTION_NAME));
        }
        userActionDao.save(userAction);
    }
    public UserAction get(Long id) { return userActionDao.get(id); }

    public List<UserAction> getAll() { return userActionDao.getAll(); }

    public  void remove(Long id) {userActionDao.remove(id);}
}
