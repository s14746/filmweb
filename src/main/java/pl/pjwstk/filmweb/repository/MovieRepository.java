package pl.pjwstk.filmweb.repository;

import pl.pjwstk.filmweb.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MovieRepository {
    private final List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        create("The Godfather");
        create("The Godfather 2");
    }

    public List<Movie> findAll() {
        return movies;
    }

    public Optional<Movie> findById(String id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    public String create(String name) {
        String movieId = name.toUpperCase().replace(" ", "_");
        Movie movie = new Movie(movieId, name);
        movies.add(movie);
        return movieId;
    }

    public void update(String movieId, String name) {
        movies.removeIf(movie -> movie.getId().equals(movieId));
        movies.add(new Movie(movieId, name));
    }
}
