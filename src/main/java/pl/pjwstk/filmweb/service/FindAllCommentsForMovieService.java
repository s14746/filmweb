package pl.pjwstk.filmweb.service;

import pl.pjwstk.filmweb.model.Comment;
import pl.pjwstk.filmweb.repository.MovieCommentRepository;

import java.util.List;

public class FindAllCommentsForMovieService {
    private final MovieCommentRepository movieCommentRepository;

    public FindAllCommentsForMovieService(MovieCommentRepository movieCommentRepository) {
        this.movieCommentRepository = movieCommentRepository;
    }

    public List<Comment> execute(String movieId) {
        return movieCommentRepository.findAll(movieId);
    }
}
