package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.repository.MovieRepository;
import pl.pjwstk.filmweb.service.model.UpdateMovieRequest;

public class UpdateMovieService {
    private final MovieRepository movieRepository;

    public UpdateMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void execute(String id, UpdateMovieRequest request) {
        movieRepository.update(id, request.getName());
    }
}
