package by.hector.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author i.sukach
 */
public class ValidGenreConstraintValidator implements ConstraintValidator<ValidGenre, String> {

   private List<String> validGenres = Arrays.asList("Action", "Horror", "Comedy");

   public void initialize(ValidGenre constraint) {
   }

   public boolean isValid(String genre, ConstraintValidatorContext context) {
      return validGenres.contains(genre);
   }
}
