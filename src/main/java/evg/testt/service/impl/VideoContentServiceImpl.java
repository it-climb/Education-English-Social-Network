package evg.testt.service.impl;


import evg.testt.dao.SequenceDao;
import evg.testt.dao.VideoContentDao;
import evg.testt.model.content.VideoFile;
import evg.testt.service.videoservices.VideoContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoContentServiceImpl implements VideoContentService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private VideoContentDao videoContentDao;

    public void save(VideoFile videoFile) {
        if(videoFile.getId()==null) {
            videoFile.setId(sequenceDao.getNextSequenceId(VideoFile.COLLECTION_NAME));
        }
        videoContentDao.save(videoFile);
    }

    public VideoFile get(Long id) {
        return videoContentDao.get(id);
    }

    public List<VideoFile> getAll() {
        return videoContentDao.getAll();
    }

    public void remove(Long id) {
        videoContentDao.remove(id);
    }

}
