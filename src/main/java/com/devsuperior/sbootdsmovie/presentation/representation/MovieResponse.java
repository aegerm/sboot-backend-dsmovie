package com.devsuperior.sbootdsmovie.presentation.representation;

import com.devsuperior.sbootdsmovie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse implements Serializable {

    private Long id;
    private String title;
    private Integer count;
    private Double score;
    private String image;

    public MovieResponse(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.count = movie.getCount();
        this.score = movie.getScore();
        this.image = movie.getImage();
    }
}
