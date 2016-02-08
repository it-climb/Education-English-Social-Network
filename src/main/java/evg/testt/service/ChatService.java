package evg.testt.service;

import evg.testt.model.Chat;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.model.User;

import java.util.List;

public interface ChatService extends Service<Chat> {

    List<Chat> getByUser(User user);

    List<Chat> getByUser(Integer user);

}
