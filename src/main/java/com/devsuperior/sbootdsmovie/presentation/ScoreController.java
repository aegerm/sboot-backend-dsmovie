package com.devsuperior.sbootdsmovie.presentation;

import com.devsuperior.sbootdsmovie.mapper.MovieMapper;
import com.devsuperior.sbootdsmovie.mapper.ScoreMapper;
import com.devsuperior.sbootdsmovie.presentation.representation.MovieResponse;
import com.devsuperior.sbootdsmovie.presentation.representation.ScoreRepresentationRequest;
import com.devsuperior.sbootdsmovie.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PutMapping
    public ResponseEntity<MovieResponse> saveScoreMovie(@RequestBody ScoreRepresentationRequest request) {
        MovieResponse response = MovieMapper.toResponse(this.scoreService.saveScore(ScoreMapper.toDomain(request)));
        return ResponseEntity.ok(response);
    }
}
