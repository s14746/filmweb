package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.model.Movie;
import pl.pjwstk.filmweb.repository.MovieRepository;

import java.util.Optional;

public class FindMovieService {
    private final MovieRepository movieRepository;

    public FindMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> execute(String movieId) {
        return movieRepository.findById(movieId);
    }
}
