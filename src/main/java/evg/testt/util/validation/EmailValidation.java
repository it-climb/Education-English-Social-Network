package evg.testt.util.validation;

import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation  implements ConstraintValidator<Unique,Object> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(Unique constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(userService.getByEmail((String) value)==value){return false;}
        return true;
    }
}
