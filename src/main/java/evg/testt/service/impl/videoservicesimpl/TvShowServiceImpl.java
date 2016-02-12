package evg.testt.service.impl.videoservicesimpl;

import evg.testt.dao.SequenceDao;
import evg.testt.dao.contentdao.TvShowDao;
import evg.testt.model.content.TvShow;
import evg.testt.service.videoservices.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TvShowServiceImpl implements TvShowService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private TvShowDao tvShowDao;

    public void save(TvShow tvShow) {
        if(tvShow.getId()==null) {
            tvShow.setId(sequenceDao.getNextSequenceId(TvShow.COLLECTION_NAME));
        }
        tvShowDao.save(tvShow);
    }

    public TvShow get(Long id) {
        return tvShowDao.get(id);
    }

    public List<TvShow> getAll() {
        return tvShowDao.getAll();
    }

    public void remove(Long id) {
        tvShowDao.remove(id);
    }

}
