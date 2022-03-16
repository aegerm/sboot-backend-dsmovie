package com.devsuperior.sbootdsmovie.service;

import com.devsuperior.sbootdsmovie.domain.Movie;
import com.devsuperior.sbootdsmovie.domain.Score;
import com.devsuperior.sbootdsmovie.domain.ScoreRequest;
import com.devsuperior.sbootdsmovie.domain.User;
import com.devsuperior.sbootdsmovie.repository.MovieRepository;
import com.devsuperior.sbootdsmovie.repository.ScoreRepository;
import com.devsuperior.sbootdsmovie.repository.UserRepository;
import com.devsuperior.sbootdsmovie.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;

    @Transactional
    public Movie saveScore(ScoreRequest request) {
        User user = this.userRepository.findByEmail(request.getEmail());

        if (user == null) {
            user = this.userRepository.saveAndFlush(User.builder().email(request.getEmail()).build());
        }

        Movie movie = this.movieRepository.findById(request.getMovieId()).orElseThrow(() -> new ObjectNotFoundException("Filme não encontrado! ID: " + request.getMovieId()));

        Score score = new Score();
        score.getId().setMovie(movie);
        score.getId().setUser(user);
        score.setScore(request.getScore());

        this.scoreRepository.saveAndFlush(score);

        double sum = 0.0;

        for (Score sc: movie.getScores()) {
            sum = sum + sc.getScore();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = this.movieRepository.save(movie);

        return movie;
    }
}
