package pl.pjwstk.filmweb;

import pl.pjwstk.filmweb.repository.MovieCommentRepository;
import pl.pjwstk.filmweb.repository.MovieRateRepository;
import pl.pjwstk.filmweb.repository.MovieRepository;
import pl.pjwstk.filmweb.service.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    private static final MovieRepository movieRepository = new MovieRepository();
    private static final MovieCommentRepository movieCommentRepository = new MovieCommentRepository();
    private static final MovieRateRepository movieRateRepository = new MovieRateRepository();

    public static final FindAllMoviesService findAllMoviesService = new FindAllMoviesService(movieRepository);
    public static final FindMovieService findMovieService = new FindMovieService(movieRepository);
    public static final AddMovieService addMovieService = new AddMovieService(movieRepository);
    public static final UpdateMovieService updateMovieService = new UpdateMovieService(movieRepository);

    public static final FindAllCommentsForMovieService findAllCommentsForMovieService = new FindAllCommentsForMovieService(movieCommentRepository);
    public static final AddCommentToMovieService addCommentToMovieService = new AddCommentToMovieService(movieCommentRepository);
    public static final DeleteCommentFromMovieService deleteCommentFromMovieService = new DeleteCommentFromMovieService(movieCommentRepository);

    public static final RateMovieService rateMovieService = new RateMovieService(movieRateRepository);
}