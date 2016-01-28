package evg.testt.dao;

import evg.testt.model.Word;
import evg.testt.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DescriptionDao extends JpaRepository<Description, Integer> {
    List<Description> findByName(String name);

    List<Description> findByWord(Word word);


}
