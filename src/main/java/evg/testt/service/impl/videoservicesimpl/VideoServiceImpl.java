package evg.testt.service.impl.videoservicesimpl;

import evg.testt.dao.SequenceDao;
import evg.testt.dao.contentdao.VideoDao;
import evg.testt.model.content.Video;
import evg.testt.service.videoservices.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private VideoDao videoDao;

    public void save(Video video) {
        if(video.getId()==null) {
            video.setId(sequenceDao.getNextSequenceId(Video.COLLECTION_NAME));
        }
        videoDao.save(video);
    }

    public Video get(Long id) {
        return videoDao.get(id);
    }

    public List<Video> getAll() {
        return videoDao.getAll();
    }

    public void remove(Long id) {
        videoDao.remove(id);
    }

}
