package com.devsuperior.sbootdsmovie.mapper;

import com.devsuperior.sbootdsmovie.domain.ScoreRequest;
import com.devsuperior.sbootdsmovie.presentation.representation.ScoreRepresentationRequest;

public class ScoreMapper {

    private ScoreMapper() {
    }

    public static ScoreRequest toDomain(ScoreRepresentationRequest request) {
        return ScoreRequest.builder().movieId(request.getMovieId()).email(request.getEmail()).score(request.getScore()).build();
    }
}
