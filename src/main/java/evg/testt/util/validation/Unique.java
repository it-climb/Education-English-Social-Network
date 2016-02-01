package evg.testt.util.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Unique {
    String message() default "{org.hibernate.validator.constraints.Unique.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
