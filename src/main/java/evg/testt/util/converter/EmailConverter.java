package evg.testt.util.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EmailConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String email) {
        StringBuilder sb = new StringBuilder ();
        sb.append(email).append("111");
        return sb.toString();
    }

    @Override
    public String convertToEntityAttribute(String emailString) {

        String[] email = emailString.split("111");

        return email[0];
    }

}
