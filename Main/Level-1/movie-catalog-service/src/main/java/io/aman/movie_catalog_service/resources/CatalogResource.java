package io.aman.movie_catalog_service.resources;

import io.aman.movie_catalog_service.models.CatalogItem;
import io.aman.movie_catalog_service.models.Rating;
import io.aman.movie_catalog_service.models.Movie;
import io.aman.movie_catalog_service.models.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/catalog")
public class CatalogResource {
    

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        
        
        // get all rated movie IDs
        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);


        return ratings.getUserRating().stream().map(rating -> {

            // For each movie ID, call movie info service and get details...
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

            // Put them all together...
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());

        })
        .collect(Collectors.toList());


    }
}





/*  Movie movie = webClientBuilder.build()
        .get()
        .uri("http://localhost:8082/movies/" + rating.getMovieId())
        .retrieve()
        .bodyToMono(Movie.class)
        .block();
*/
