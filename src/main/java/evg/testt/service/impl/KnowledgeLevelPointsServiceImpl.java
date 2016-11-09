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

    /**
     * <p>it allows to find in database all KnowledgeLevelPoints for given User</p>
     * @param user - search param
     * @return List of User KnowledgeLevelPoints
     */
    public List<KnowledgeLevelPoints> getListByUser(User user) {
        return dao.findByUser(user);
    }

    /**
     * <p>it allows to find in database all KnowledgeLevelPoints for given User</p>
     * <p>result provided as Map witch key is subject of KnowledgeLevelPoints</p>
     * @param user - search param
     * @return Map where key is subject and value is KnowledgeLevelPoints
     */
    public Map<String, KnowledgeLevelPoints> getMapByUser(User user) {
        List<KnowledgeLevelPoints> klpList = dao.findByUser(user);
        Map<String, KnowledgeLevelPoints> klpMap = new HashMap<>();
        for (KnowledgeLevelPoints klp : klpList) {
            klpMap.put(klp.getSubject(), klp);
        }
        return klpMap;
    }

    /**
     * <p>it allows to find in database KnowledgeLevelPoints for given subject and User</p>
     * @param user - search param
     * @param subject - search param. Temporarily String, must be replaced to type Subject model
     * @return KnowledgeLevelPoints for given User and subject
     */
    public KnowledgeLevelPoints findByUserAndSubject(User user, String subject) {
        return dao.findByUserAndSubject(user, subject);
    }
}
