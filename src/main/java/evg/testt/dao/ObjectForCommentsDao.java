package evg.testt.dao;

import evg.testt.model.ObjectForComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjectForCommentsDao {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(ObjectForComments objectForComments) {
        mongoOperations.save(objectForComments);
    }

    public ObjectForComments get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), ObjectForComments.class);
    }

    public List<ObjectForComments> getAll() {
        return mongoOperations.findAll(ObjectForComments.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), ObjectForComments.class);
    }


}
