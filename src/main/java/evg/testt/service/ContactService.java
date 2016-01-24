package evg.testt.service;

import evg.testt.dao.ContactDao;
import evg.testt.dao.SequenceDao;
import evg.testt.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created on 9/10/15.
 */
@Service
public class ContactService {

    @Autowired
    private SequenceDao sequenceDao;
    @Autowired private ContactDao contactDao;

    public void save(Contact contact) {
        if(contact.getId()==null) {
            contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
        }
        contactDao.save(contact);
    }

    public Contact get(Long id) {
        return contactDao.get(id);
    }

    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    public void remove(Long id) {
        contactDao.remove(id);
    }


}
