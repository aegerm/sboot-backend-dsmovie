package com.devsuperior.sbootdsmovie.presentation;

import com.devsuperior.sbootdsmovie.mapper.MovieMapper;
import com.devsuperior.sbootdsmovie.presentation.representation.MovieResponse;
import com.devsuperior.sbootdsmovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieResponse>> findAllMovies(Pageable pageable) {
        return ResponseEntity.ok(MovieMapper.toResponsePage(this.movieService.findAllMovies(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(MovieMapper.toResponse(this.movieService.findMovieById(id)));
    }
}
