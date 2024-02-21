// Write your code here
package com.example.movie.repository;

import com.example.movie.model.Movie;
import java.util.ArrayList;

public interface MovieRepository {

    public ArrayList<Movie> getAll();

    public Movie create(Movie movie);

    public Movie getById(int movieId);

    public Movie updateById(int movieId, Movie movie);

    public void deleteById(int movieId);
}