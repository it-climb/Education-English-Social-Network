package evg.testt.service;

import evg.testt.dao.ActivityContentDao;
import evg.testt.dao.SequenceDao;
import evg.testt.model.activitycontent.ActivityContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ActivityContentService {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private ActivityContentDao activityContentDao;

    public ActivityContent save(ActivityContent activityContent) {
        if(activityContent.getId()==null) {
            activityContent.setId(sequenceDao.getNextSequenceId(ActivityContent.COLLECTION_NAME));
        }
        activityContentDao.save(activityContent);
        return activityContent;
    }

    public ActivityContent get(Long id) {
        return activityContentDao.get(id);
    }

    public List<ActivityContent> getAll() {
        return activityContentDao.getAll();
    }

    public void remove(Long id) {
        activityContentDao.remove(id);
    }
}
