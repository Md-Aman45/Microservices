package io.aman.movie_info_service.services;

import io.aman.movie_info_service.models.Movie;
import io.aman.movie_info_service.models.TmdbMovie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieInfoService {
    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String tmdbUrl;

    private final RestTemplate restTemplate;

    public MovieInfoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(String movieId) {
        String url = tmdbUrl + "/" + movieId + "?api_key=" + apiKey;

        io.aman.movie_info_service.models.TmdbMovie tmdbMovie = 
                restTemplate.getForObject(url, TmdbMovie.class);

        return new Movie(
            movieId,
            tmdbMovie.getTitle(),
            tmdbMovie.getOverview()
        );
    }
}

