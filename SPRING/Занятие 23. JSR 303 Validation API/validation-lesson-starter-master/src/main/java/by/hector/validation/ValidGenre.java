package by.hector.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author i.sukach
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidGenreConstraintValidator.class)
public @interface ValidGenre {

    String message() default "Please, enter one of the following genres: 'Comedy', 'Action', 'Horror'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
