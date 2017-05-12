package pl.pjwstk.filmweb.repository;

import java.util.ArrayList;
import java.util.List;

public class MovieRateRepository {
    private final List<MovieRate> movieRates = new ArrayList<>();

    public void create(String movieId, int rate) {
        MovieRate movieRate = new MovieRate(movieId, rate);
        movieRates.add(movieRate);
    }

    private static class MovieRate {
        private final String movieId;
        private final int rate;

        public MovieRate(String movieId, int rate) {
            this.movieId = movieId;
            this.rate = rate;
        }

        public String getMovieId() {
            return movieId;
        }

        public int getRate() {
            return rate;
        }
    }
}
