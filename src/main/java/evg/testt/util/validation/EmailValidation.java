package evg.testt.util.validation;

import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailValidation  implements ConstraintValidator<Unique, Object> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(Unique unique) {
        //TODO
    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext context) {
        User user = (User) target;

        /*List<User> users = userService.getByEmails(user.getEmail());
        if (users.size() !=0) return users.get(0).getId() == user.getId();*/

        User userValid = userService.getByEmail(user.getEmail());
        if(userValid != null) return userValid.getId() == user.getId();
        return true;
    }
}
