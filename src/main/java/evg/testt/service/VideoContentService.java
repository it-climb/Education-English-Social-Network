package evg.testt.service;


import evg.testt.dao.SequenceDao;
import evg.testt.dao.VideoContentDao;
import evg.testt.model.VideoContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoContentService {

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    private VideoContentDao videoContentDao;

    public void save(VideoContent videoContent) {
        if(videoContent.getId()==null) {
            videoContent.setId(sequenceDao.getNextSequenceId(VideoContent.COLLECTION_NAME));
        }
        videoContentDao.save(videoContent);
    }

    public VideoContent get(Long id) {
        return videoContentDao.get(id);
    }

    public List<VideoContent> getAll() {
        return videoContentDao.getAll();
    }

    public void remove(Long id) {
        videoContentDao.remove(id);
    }

}
