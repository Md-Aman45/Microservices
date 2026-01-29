package io.aman.movie_info_service.resources;

import io.aman.movie_info_service.models.Movie;
import io.aman.movie_info_service.services.MovieInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieResource {

    private final MovieInfoService movieInfoService;

    public MovieResource(MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }
    
    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {
        return movieInfoService.getMovie(movieId);
    }
}
