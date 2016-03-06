package evg.testt.dao;

import evg.testt.model.activitycontent.ActivityContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sergei-bragin on 28.02.16.
 */
@Repository
public class ActivityContentDao {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(ActivityContent activityContent) {
        mongoOperations.save(activityContent);
    }

    public ActivityContent get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), ActivityContent.class);
    }

    public List<ActivityContent> getAll() {
        return mongoOperations.findAll(ActivityContent.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), ActivityContent.class);
    }
}
