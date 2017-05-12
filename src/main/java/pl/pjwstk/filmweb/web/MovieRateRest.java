package pl.pjwstk.filmweb.web;

import pl.pjwstk.filmweb.ApplicationConfig;
import pl.pjwstk.filmweb.service.RateMovieService;
import pl.pjwstk.filmweb.service.model.RateMovieRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/movies/{movieId}/rates")
public class MovieRateRest {
    private final RateMovieService rateMovieService = ApplicationConfig.rateMovieService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCommentToMovie(@PathParam("movieId") String id, RateMovieRequest request) {
        rateMovieService.execute(id, request);
    }
}