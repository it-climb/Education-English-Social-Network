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
        return dao.findByUser(user);
    }
}
