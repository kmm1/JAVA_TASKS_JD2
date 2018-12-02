package by.itacademy.boot.repository;

import by.itacademy.boot.entity.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * @author i.sukach
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
