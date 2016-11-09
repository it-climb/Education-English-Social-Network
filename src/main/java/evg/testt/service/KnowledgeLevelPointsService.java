package evg.testt.service;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;

import java.util.List;
import java.util.Map;

public interface KnowledgeLevelPointsService extends Service<KnowledgeLevelPoints> {
    /**
     * <p>it allows to find in database all KnowledgeLevelPoints for given User</p>
     * @param user - search param
     * @return List of User KnowledgeLevelPoints
     */
    List<KnowledgeLevelPoints> getListByUser(User user);

    /**
     * <p>it allows to find in database all KnowledgeLevelPoints for given User</p>
     * <p>result provided as Map witch key is subject of KnowledgeLevelPoints</p>
     * @param user - search param
     * @return Map where key is subject and value is KnowledgeLevelPoints
     */
    Map<String, KnowledgeLevelPoints> getMapByUser(User user);

    /**
     * <p>it allows to find in database KnowledgeLevelPoints for given subject and User</p>
     * @param user - search param
     * @param subject - search param. Temporarily String, must be replaced to type Subject model
     * @return KnowledgeLevelPoints for given User and subject
     */
    KnowledgeLevelPoints findByUserAndSubject(User user, String subject);
}
