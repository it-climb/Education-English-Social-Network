package evg.testt.service.impl;

import evg.testt.dao.ChatDao;
import evg.testt.dao.EmployeeDao;
import evg.testt.model.Chat;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.model.User;
import evg.testt.service.ChatService;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl extends BaseService<Chat, ChatDao> implements ChatService {

    public List<Chat> getByUser(User user){
        return dao.findByUser(user);
    }

    public List<Chat> getByUser(Integer id){
        return dao.findByUser(User.newBuilder().setId(id).build());
    }

}
