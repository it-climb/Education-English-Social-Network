package evg.testt.dao;

import evg.testt.model.userActionModels.Action;
import evg.testt.model.userActionModels.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserActionDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(UserAction userAction) {
        mongoOperations.save(userAction);
    }

    public UserAction get (Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), UserAction.class);
    }

    public List<UserAction> getAll() { return mongoOperations.findAll(UserAction.class); }

    public void remove(Long id) { mongoOperations.remove(Query.query(Criteria.where("id").is(id)), UserAction.class); }

    public void update(String email,Action action){
        Query query = new Query();
        query.addCriteria(Criteria.where("userEmail").is(email));

        Update update = new Update();
        update.push("actions", action);

        mongoOperations.upsert(query, update, UserAction.class);
    }


}
