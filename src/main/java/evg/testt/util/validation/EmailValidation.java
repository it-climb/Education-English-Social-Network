package evg.testt.util.validation;

import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailValidation  implements ConstraintValidator<Unique, String> {

    @Autowired
    UserService userService;

    private String message;

    @Override
    public void initialize(Unique unique) {
        this.message = unique.message();
    }

    @Override
    public boolean isValid(String target, ConstraintValidatorContext context) {
        try {
            User user = userService.getByEmail(target);
            if(user != null) return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
