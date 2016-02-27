package evg.testt.dao.contentdao;

import evg.testt.model.content.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VideoDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Video video) {
        mongoOperations.save(video);
    }

    public Video get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Video.class);
    }

    public List<Video> getAll() {
        return mongoOperations.findAll(Video.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Video.class);
    }

}
