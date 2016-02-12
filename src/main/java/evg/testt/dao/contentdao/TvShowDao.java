package evg.testt.dao.contentdao;

import evg.testt.model.content.Movie;
import evg.testt.model.content.TvShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TvShowDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(TvShow tvShow) {
        mongoOperations.save(tvShow);
    }

    public TvShow get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), TvShow.class);
    }

    public List<TvShow> getAll() {
        return mongoOperations.findAll(TvShow.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), TvShow.class);
    }

}
