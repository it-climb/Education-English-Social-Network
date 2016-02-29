package evg.testt.service.impl;


import evg.testt.dao.KnowledgeLevelPointsDao;
import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;
import evg.testt.service.KnowledgeLevelPointsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KnowledgeLevelPointsServiceImpl extends BaseService<KnowledgeLevelPoints, KnowledgeLevelPointsDao> implements KnowledgeLevelPointsService {
    public List<KnowledgeLevelPoints> getListByUser(User user) {
        return dao.findByUser(user);
    }
    public Map<String, KnowledgeLevelPoints> getMapByUser(User user) {
        List<KnowledgeLevelPoints> klpList = dao.findByUser(user);
        Map<String, KnowledgeLevelPoints> klpMap = new HashMap<>();
        for (KnowledgeLevelPoints klp : klpList) {
            klpMap.put(klp.getSubject(), klp);
        }
        return klpMap;
    }
    public KnowledgeLevelPoints findByUserAndSubject(User user, String subject) {
        return dao.findByUserAndSubject(user, subject);
    }
}
