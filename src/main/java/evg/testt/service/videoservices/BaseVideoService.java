package evg.testt.service.videoservices;

import evg.testt.model.content.VideoFile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BaseVideoService<T> {

    void save(T o);

    T get(Long id);

    List<T> getAll();

    void remove(Long id);

}
