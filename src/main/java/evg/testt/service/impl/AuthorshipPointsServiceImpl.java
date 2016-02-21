package evg.testt.service.impl;

import evg.testt.dao.AuthorshipPointsDao;
import evg.testt.model.AuthorshipPoints;
import evg.testt.model.User;
import evg.testt.service.AuthorshipPointsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorshipPointsServiceImpl extends BaseService<AuthorshipPoints, AuthorshipPointsDao> implements AuthorshipPointsService {
    public AuthorshipPoints getByUser(User user) {
        AuthorshipPoints authorshipPoints = dao.findByUser(user);
        if (authorshipPoints != null) {
            return authorshipPoints;
        } else {
            authorshipPoints = new AuthorshipPoints();
            authorshipPoints.setUser(user);
            authorshipPoints.setAuthorshipPoints(0);
            dao.save(authorshipPoints);
            return authorshipPoints;
        }
    }
}
