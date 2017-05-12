package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.repository.MovieCommentRepository;

public class DeleteCommentFromMovieService {
    private final MovieCommentRepository movieCommentRepository;

    public DeleteCommentFromMovieService(MovieCommentRepository movieCommentRepository) {
        this.movieCommentRepository = movieCommentRepository;
    }

    public void execute(String movieId, String commentId) {
        movieCommentRepository.delete(movieId, commentId);
    }
}
