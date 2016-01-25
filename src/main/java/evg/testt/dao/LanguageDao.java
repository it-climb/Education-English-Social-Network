package evg.testt.dao;

import evg.testt.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LanguageDao extends JpaRepository<Language, Integer> {
}
