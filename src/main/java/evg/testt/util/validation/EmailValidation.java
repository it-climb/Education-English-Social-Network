package evg.testt.util.validation;

import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation  implements ConstraintValidator<Unique,String> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(Unique unique) {
        //TODO
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService.getByEmail(email) == null;
    }
}
