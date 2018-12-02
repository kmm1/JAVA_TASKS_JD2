package by.hector.controller;

import by.hector.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author i.sukach
 */
@Controller
@SessionAttributes(value = {"movie"})
public class MovieController {

    @ModelAttribute
    public Movie movie() {
        return new Movie();
    }

    @GetMapping("/movie")
    public String showMoviePage() {
        return "movie";
    }

    @PostMapping("/movie")
    public ModelAndView saveMovie(@SessionAttribute @Valid Movie movie, BindingResult bindingResult, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        System.out.println(movie);
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("movie", model);
    }
}
