/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.Movie;
import java.util.*;

@Service
public class MovieJpaService implements MovieRepository {
    @Autowired
    MovieJpaRepository mjr;

    public ArrayList<Movie> getAll() {
        List<Movie> l = mjr.findAll();
        ArrayList<Movie> arr = new ArrayList<>(l);
        return arr;
    }

    @Override
    public Movie create(Movie movie) {
        mjr.save(movie);
        return movie;
    }

    @Override
    public Movie getById(int movieId) {
        try {
            Movie m = mjr.findById(movieId).get();
            return m;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie updateById(int movieId, Movie movie) {
        try {
            Movie m = mjr.findById(movieId).get();
            if (movie.getMovieName() != null) {
                m.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                m.setLeadActor(movie.getLeadActor());
            }
            mjr.save(m);
            return m;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteById(int movieId) {
        try {
            mjr.deleteById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
