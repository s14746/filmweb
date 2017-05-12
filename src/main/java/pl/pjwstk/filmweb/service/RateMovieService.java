package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.repository.MovieRateRepository;
import pl.pjwstk.filmweb.service.model.RateMovieRequest;

public class RateMovieService {
    private final MovieRateRepository movieRateRepository;

    public RateMovieService(MovieRateRepository movieRateRepository) {
        this.movieRateRepository = movieRateRepository;
    }

    public void execute(String movieId, RateMovieRequest request) {
        movieRateRepository.create(movieId, request.getRate());
    }
}
