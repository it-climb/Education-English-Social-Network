package evg.testt.service.impl;

import evg.testt.dao.WordDao;
import evg.testt.model.Word;
import evg.testt.service.WordService;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl extends BaseService<Word, WordDao> implements WordService {
}
