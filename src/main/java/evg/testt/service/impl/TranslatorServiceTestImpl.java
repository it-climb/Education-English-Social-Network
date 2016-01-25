package evg.testt.service.impl;

import evg.testt.dto.TranslatorDto;
import evg.testt.service.TranslatorServise;
import org.springframework.stereotype.Service;


@Service
public class TranslatorServiceTestImpl implements TranslatorServise {

    public TranslatorDto translate(TranslatorDto translatorDto) {
        translatorDto.setTextOut("Якось так ми i перекладаемо...");// test
        return translatorDto;
    }

}
