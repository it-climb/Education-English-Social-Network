package evg.testt.service;

import evg.testt.model.AuthorshipPoints;
import evg.testt.model.User;

import java.util.List;

public interface AuthorshipPointsService extends Service<AuthorshipPoints>{
    /**
     * <p>it allows to find in database AuthorshipPoints for given User</p>
     * @param user - search param
     * @return AuthorshipPoints
     */
    AuthorshipPoints getByUser(User user);
}
