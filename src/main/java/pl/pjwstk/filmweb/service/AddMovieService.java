package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.repository.MovieRepository;
import pl.pjwstk.filmweb.service.model.AddMovieRequest;

public class AddMovieService {
    private final MovieRepository movieRepository;

    public AddMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public String execute(AddMovieRequest request) {
        return movieRepository.create(request.getName());
    }
}
