package evg.testt.service.impl;

import evg.testt.dao.DescriptionDao;
import evg.testt.model.Description;
import evg.testt.model.Word;
import evg.testt.service.DescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionServiceImpl extends BaseService<Description, DescriptionDao> implements DescriptionService {
    public List<Description> getByWord(Word word){
        return dao.findByWord(word);
    }

    public List<Description> getByWord(Integer id){
        return dao.findByWord(Word.newBuilder().setId(id).build());
    }
}
