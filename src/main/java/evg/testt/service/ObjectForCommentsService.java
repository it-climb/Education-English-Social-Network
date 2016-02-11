package evg.testt.service;

import evg.testt.dao.ObjectForCommentsDao;
import evg.testt.dao.SequenceDao;
import evg.testt.model.ObjectForComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectForCommentsService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private ObjectForCommentsDao objectForCommentsDao;

    public void save(ObjectForComments objectForComments){
        if(objectForComments.getId()==null){
            objectForComments.setId(sequenceDao.getNextSequenceId(objectForComments.COLLECTION_NAME));
        }
        objectForCommentsDao.save(objectForComments);
    }

    public ObjectForComments get(Long id){return objectForCommentsDao.get(id);}

    public List<ObjectForComments> getAll(){return objectForCommentsDao.getAll();}

    public void remove(Long id){objectForCommentsDao.remove(id);}

}
