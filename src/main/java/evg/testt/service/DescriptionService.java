package evg.testt.service;

import evg.testt.model.Description;
import evg.testt.model.Word;

import java.util.List;

public interface DescriptionService extends Service<Description>{
    List<Description> getByWord(Word word);

    List<Description> getByWord(Integer word);

}
