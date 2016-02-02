package evg.testt.util;

import evg.testt.model.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if( !EmailValidator.getInstance().isValid( user.getEmail() ) ){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }

    }
}
*/
