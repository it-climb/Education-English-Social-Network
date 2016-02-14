package evg.testt.service.impl;


import evg.testt.dao.KnowledgeLevelPointsDao;
import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import evg.testt.service.KnowledgeLevelPointsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeLevelPointsServiceImpl extends BaseService<KnowledgeLevelPoints, KnowledgeLevelPointsDao> implements KnowledgeLevelPointsService {
    public List<KnowledgeLevelPoints> getByUser(User user) {
        return dao.findByUser(user);
    }
}
