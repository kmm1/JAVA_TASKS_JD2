package by.itacademy.boot.controller;

import by.itacademy.boot.entity.Movie;
import by.itacademy.boot.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author i.sukach
 */
@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movie/{id}")
    public Movie movie(@PathVariable("id") Long id) {
        return movieRepository.findOne(id);
    }

    @PostMapping("/saveMovie")
    public void saveMovie(@RequestBody Movie movie) {
        System.out.println(movie);
    }
}
