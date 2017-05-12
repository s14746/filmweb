package pl.pjwstk.filmweb.web;

import pl.pjwstk.filmweb.ApplicationConfig;
import pl.pjwstk.filmweb.model.Comment;
import pl.pjwstk.filmweb.service.AddCommentToMovieService;
import pl.pjwstk.filmweb.service.DeleteCommentFromMovieService;
import pl.pjwstk.filmweb.service.FindAllCommentsForMovieService;
import pl.pjwstk.filmweb.service.model.AddCommentToMovieRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movies/{movieId}/comments")
public class MovieCommentsRest {
    private final FindAllCommentsForMovieService findAllCommentsForMovieService = ApplicationConfig.findAllCommentsForMovieService;
    private final AddCommentToMovieService addCommentToMovieService = ApplicationConfig.addCommentToMovieService;
    private final DeleteCommentFromMovieService deleteCommentFromMovieService = ApplicationConfig.deleteCommentFromMovieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> findAllCommentsForMovie(@PathParam("movieId") String id) {
        return findAllCommentsForMovieService.execute(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCommentToMovie(@PathParam("movieId") String id, AddCommentToMovieRequest request) {
        Integer movieCommentId = addCommentToMovieService.execute(id, request);
        return Response.ok(movieCommentId).build();
    }

    @Path("/{commentId}")
    @DELETE
    public void deleteCommentToMovie(@PathParam("movieId") String movieId, @PathParam("commentId") String commentId) {
        deleteCommentFromMovieService.execute(movieId, commentId);
    }
}