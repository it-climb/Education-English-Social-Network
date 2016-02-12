package evg.testt.dao.contentdao;

import evg.testt.model.content.Movie;
import evg.testt.model.content.Serial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SerialDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Serial serial) {
        mongoOperations.save(serial);
    }

    public Serial get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Serial.class);
    }

    public List<Serial> getAll() {
        return mongoOperations.findAll(Serial.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Serial.class);
    }

}
