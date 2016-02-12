package evg.testt.service.impl.videoservicesimpl;

import evg.testt.dao.SequenceDao;
import evg.testt.dao.contentdao.SerialDao;
import evg.testt.model.content.Serial;
import evg.testt.service.videoservices.SerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SerialServiceImpl implements SerialService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private SerialDao serialDao;

    public void save(Serial serial) {
        if(serial.getId()==null) {
            serial.setId(sequenceDao.getNextSequenceId(Serial.COLLECTION_NAME));
        }
        serialDao.save(serial);
    }

    public Serial get(Long id) {
        return serialDao.get(id);
    }

    public List<Serial> getAll() {
        return serialDao.getAll();
    }

    public void remove(Long id) {
        serialDao.remove(id);
    }

}
