package evg.testt.service.impl;

import evg.testt.dao.UserDataDao;
import evg.testt.model.KnowledgeLevelUnits;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.service.UserDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDataServiceImpl extends BaseService<UserData, UserDataDao> implements UserDataService{

    public UserData findByUser(User user) {
        UserData userData = dao.findByUser(user);
        if (userData != null) {
            return userData;
        } else {
            userData = new UserData();
            userData.setUser(user);
            dao.save(userData);
            return userData;
        }
    }

    public void addKnowledgeLevelUnits(UserData userData, Set< KnowledgeLevelUnits > knowledgeLevelUnitsSet) {
        Set<KnowledgeLevelUnits> userKnowledgeLevelUnits = userData.getKnowledgeLevelUnitsSet();
        for (KnowledgeLevelUnits knowledgeLevelUnits: knowledgeLevelUnitsSet) {
            userKnowledgeLevelUnits.add(knowledgeLevelUnits);
        }
        userData.setKnowledgeLevelUnitsSet(userKnowledgeLevelUnits);
    }

    public List<KnowledgeLevelUnits> getUnitsPerSubject(UserData userData) {

        Set<KnowledgeLevelUnits> levelUnitses = userData.getKnowledgeLevelUnitsSet();
        List<KnowledgeLevelUnits> unitsList =new ArrayList<>();
        for (KnowledgeLevelUnits levelUnits: levelUnitses) {
            boolean isAdded = false;
            for (int i = 0; i < unitsList.size(); i++) {
                if (levelUnits.getSubject().equals(unitsList.get(i).getSubject())) {
                    unitsList.get(i).setLevelUnits(unitsList.get(i).getLevelUnits() + levelUnits.getLevelUnits());
                    isAdded = true;
                    break;
                }
            }
            if (isAdded == false) {
                unitsList.add(levelUnits);
            }
        }
        return unitsList;
    }

}
