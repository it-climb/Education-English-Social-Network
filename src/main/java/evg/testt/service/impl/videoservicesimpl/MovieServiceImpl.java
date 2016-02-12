package evg.testt.service.impl.videoservicesimpl;

import evg.testt.dao.contentdao.MovieDao;
import evg.testt.dao.SequenceDao;
import evg.testt.model.content.Movie;
import evg.testt.service.videoservices.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private MovieDao movieDao;

    public void save(Movie movie) {
        if(movie.getId()==null) {
            movie.setId(sequenceDao.getNextSequenceId(Movie.COLLECTION_NAME));
        }
        movieDao.save(movie);
    }

    public Movie get(Long id) {
        return movieDao.get(id);
    }

    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    public void remove(Long id) {
        movieDao.remove(id);
    }

}
