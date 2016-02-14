package evg.testt.service;

import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.model.User;

import java.util.List;

public interface KnowledgeLevelPointsService extends Service<KnowledgeLevelPoints> {
    public List<KnowledgeLevelPoints> getByUser(User user);
}
