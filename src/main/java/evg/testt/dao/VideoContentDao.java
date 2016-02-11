package evg.testt.dao;

import evg.testt.model.content.VideoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 31.01.16.
 */
@Repository
public class VideoContentDao{

    @Autowired
    private MongoOperations mongoOperations;

    public void save(VideoFile videoFile) {
        mongoOperations.save(videoFile);
    }

    public VideoFile get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), VideoFile.class);
    }

    public List<VideoFile> getAll() {
        return mongoOperations.findAll(VideoFile.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), VideoFile.class);
    }

}


