package evg.testt.service;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;

import java.util.List;
import java.util.Map;

public interface KnowledgeLevelPointsService extends Service<KnowledgeLevelPoints> {
    List<KnowledgeLevelPoints> getListByUser(User user);
    Map<String, KnowledgeLevelPoints> getMapByUser(User user);
    KnowledgeLevelPoints findByUserAndSubject(User user, String subject);
}
