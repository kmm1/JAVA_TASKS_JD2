package by.hector.entity;

import by.hector.validation.MovieLength;
import by.hector.validation.ValidGenre;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author i.sukach
 */
@Data
public class Movie {

    @NotEmpty(message = "movie.validation.error.name.not_empty")
    private String name;

    @MovieLength
    private int length;

    @ValidGenre
    private String genre;

    @Pattern(regexp = "\\+375\\s\\((29|33|44|25)\\)\\s\\d{3}-\\d{2}-\\d{2}")
    private String directorPhoneNumber;
}
