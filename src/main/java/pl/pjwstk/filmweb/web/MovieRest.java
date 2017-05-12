package pl.pjwstk.filmweb.web;

import pl.pjwstk.filmweb.ApplicationConfig;
import pl.pjwstk.filmweb.model.Movie;
import pl.pjwstk.filmweb.service.AddMovieService;
import pl.pjwstk.filmweb.service.FindAllMoviesService;
import pl.pjwstk.filmweb.service.FindMovieService;
import pl.pjwstk.filmweb.service.UpdateMovieService;
import pl.pjwstk.filmweb.service.model.AddMovieRequest;
import pl.pjwstk.filmweb.service.model.UpdateMovieRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movies")
public class MovieRest {
    private final FindAllMoviesService findAllMoviesService = ApplicationConfig.findAllMoviesService;
    private final FindMovieService findMovieService = ApplicationConfig.findMovieService;
    private final AddMovieService addMovieService = ApplicationConfig.addMovieService;
    private final UpdateMovieService updateMovieService = ApplicationConfig.updateMovieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> findAllMovies() {
        return findAllMoviesService.execute();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMovieById(@PathParam("id") String id) {
        return findMovieService.execute(id)
                .map(movie -> Response.ok(movie).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(AddMovieRequest request) {
        String movieId = addMovieService.execute(request);
        return Response.ok(movieId).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMovie(@PathParam("id") String id, UpdateMovieRequest request) {
        updateMovieService.execute(id, request);
        return Response.ok().build();
    }
}