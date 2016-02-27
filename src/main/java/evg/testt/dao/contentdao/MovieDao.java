package evg.testt.dao.contentdao;

import evg.testt.model.content.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MovieDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Movie movie) {
        mongoOperations.save(movie);
    }

    public Movie get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Movie.class);
    }

    public List<Movie> getAll() {
        return mongoOperations.findAll(Movie.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Movie.class);
    }

}


