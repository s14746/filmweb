package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.model.Movie;
import pl.pjwstk.filmweb.repository.MovieRepository;

import java.util.List;

public class FindAllMoviesService {
    private final MovieRepository movieRepository;

    public FindAllMoviesService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> execute() {
        return movieRepository.findAll();
    }
}
