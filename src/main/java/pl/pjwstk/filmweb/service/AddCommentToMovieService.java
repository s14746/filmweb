package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.repository.MovieCommentRepository;
import pl.pjwstk.filmweb.service.model.AddCommentToMovieRequest;

public class AddCommentToMovieService {
    private final MovieCommentRepository movieCommentRepository;

    public AddCommentToMovieService(MovieCommentRepository movieCommentRepository) {
        this.movieCommentRepository = movieCommentRepository;
    }

    public Integer execute(String id, AddCommentToMovieRequest request) {
        return movieCommentRepository.create(id, request.getComment());
    }
}
