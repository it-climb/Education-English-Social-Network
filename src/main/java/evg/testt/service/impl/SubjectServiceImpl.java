package evg.testt.service.impl;

import evg.testt.dao.SubjectDao;
import evg.testt.model.Subject;
import evg.testt.service.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends BaseService<Subject, SubjectDao> implements SubjectService{
    public Subject findByName(String name) {
        return dao.findByName(name);
    }
}
