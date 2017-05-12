package pl.pjwstk.filmweb.repository;

import pl.pjwstk.filmweb.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MovieCommentRepository {
    private int id = 1;
    private final List<MovieComment> comments = new ArrayList<>();

    public MovieCommentRepository() {
        create("THE_GODFATHER", "Comment 1");
        create("THE_GODFATHER", "Comment 2");
    }

    public List<Comment> findAll(String movieId) {
        return comments.stream()
                .filter(movieComment -> movieComment.getMovieId().equals(movieId))
                .map(MovieComment::getComment)
                .collect(Collectors.toList());
    }

    public Integer create(String movieId, String comment) {
        Integer commentId = id++;
        Comment newComment = new Comment(commentId, comment);

        MovieComment movieComment = new MovieComment(movieId, newComment);

        comments.add(movieComment);

        return commentId;
    }

    public void delete(String movieId, String commentId) {
        comments.removeIf(movieComment -> movieComment.getMovieId().equals(movieId) && movieComment.getComment().getId().equals(commentId));
    }

    private static class MovieComment {
        private final String movieId;
        private final Comment comment;

        public MovieComment(String movieId, Comment comment) {
            this.movieId = movieId;
            this.comment = comment;
        }

        public String getMovieId() {
            return movieId;
        }

        public Comment getComment() {
            return comment;
        }
    }
}
