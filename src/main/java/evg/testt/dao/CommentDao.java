package evg.testt.dao;

import evg.testt.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Comment comment) {
        mongoOperations.save(comment);
    }

    public Comment get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Comment.class);
    }

    public List<Comment> getAll() {
        return mongoOperations.findAll(Comment.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Comment.class);
    }



}
