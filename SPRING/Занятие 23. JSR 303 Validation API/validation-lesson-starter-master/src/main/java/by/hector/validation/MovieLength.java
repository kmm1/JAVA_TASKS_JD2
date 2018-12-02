package by.hector.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

/**
 * @author i.sukach
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Min(10)
@Max(240)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface MovieLength {

    String message() default "Movie length should be from 10 to 240 minutes";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
