package evg.testt.service;

import evg.testt.model.AuthorshipPoints;
import evg.testt.model.User;

import java.util.List;

public interface AuthorshipPointsService extends Service<AuthorshipPoints>{
    AuthorshipPoints getByUser(User user);
}
