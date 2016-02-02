package evg.testt.dao;

import evg.testt.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WordDao extends JpaRepository<Word, Integer> {
}
