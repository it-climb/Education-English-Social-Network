package evg.testt.service;

import evg.testt.model.KnowledgeLevelUnits;
import evg.testt.model.User;
import evg.testt.model.UserData;

import java.util.List;
import java.util.Set;

public interface UserDataService extends Service<UserData>{
    UserData findByUser(User user);
    void addKnowledgeLevelUnits(UserData userData, Set< KnowledgeLevelUnits > knowledgeLevelUnitsSet);
    List<KnowledgeLevelUnits> getUnitsPerSubject(UserData userData);
}
