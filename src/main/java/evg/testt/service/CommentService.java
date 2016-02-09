package evg.testt.service;

import evg.testt.dao.CommentDao;
import evg.testt.dao.SequenceDao;
import evg.testt.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private CommentDao commentDao;

    public void save(Comment comment){
        if(comment.getId()==null){
            comment.setId(sequenceDao.getNextSequenceId(Comment.COLLECTION_NAME));
        }
        commentDao.save(comment);
    }

    public Comment get(Long id){return commentDao.get(id);}

    public List<Comment> getAll(){return commentDao.getAll();}

    public void remove(Long id){commentDao.remove(id);}

}
