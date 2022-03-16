package com.devsuperior.sbootdsmovie.service;

import com.devsuperior.sbootdsmovie.domain.Movie;
import com.devsuperior.sbootdsmovie.repository.MovieRepository;
import com.devsuperior.sbootdsmovie.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<Movie> findAllMovies(Pageable pageable) {
        return this.movieRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Movie findMovieById(Long id) {
        Optional<Movie> movie = this.movieRepository.findById(id);
        return movie.orElseThrow(() -> new ObjectNotFoundException("Filme não encontrado! ID: " + id));
    }
}
