package evg.testt.service;

import evg.testt.model.Subject;

public interface SubjectService extends Service<Subject> {
    Subject findByName(String name);
}
