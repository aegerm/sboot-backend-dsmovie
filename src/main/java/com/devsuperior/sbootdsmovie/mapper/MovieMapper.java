package com.devsuperior.sbootdsmovie.mapper;

import com.devsuperior.sbootdsmovie.domain.Movie;
import com.devsuperior.sbootdsmovie.presentation.representation.MovieRequest;
import com.devsuperior.sbootdsmovie.presentation.representation.MovieResponse;
import org.springframework.data.domain.Page;

public class MovieMapper {

    private MovieMapper() {
    }

    public static Movie toDomain(MovieRequest request) {
        return Movie.builder().id(request.getId())
                              .title(request.getTitle())
                              .score(request.getScore()).image(request.getImage()).build();
    }

    public static MovieRequest toRequest(Movie movie) {
        return MovieRequest.builder().id(movie.getId())
                                     .title(movie.getTitle())
                                     .score(movie.getScore())
                                     .image(movie.getImage()).build();
    }

    public static Page<MovieResponse> toResponsePage(Page<Movie> moviePage) {
        return moviePage.map(MovieResponse::new);
    }

    public static MovieResponse toResponse(Movie movie) {
        return MovieResponse.builder().id(movie.getId()).image(movie.getImage()).score(movie.getScore()).title(movie.getTitle()).count(movie.getCount()).build();
    }
}
