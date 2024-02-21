/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;
import java.util.*;

@RestController
public class MovieController {
    @Autowired
    MovieJpaService mjp;

    @GetMapping("/movies")
    public ArrayList<Movie> getMethod() {
        return mjp.getAll();
    }

    @PostMapping("/movies")
    public Movie postMethod(@RequestBody Movie movie) {
        return mjp.create(movie);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMethodById(@PathVariable("movieId") int movieId) {
        return mjp.getById(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie putMethod(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return mjp.updateById(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMethod(@PathVariable("movieId") int movieId) {
        mjp.deleteById(movieId);
    }
}