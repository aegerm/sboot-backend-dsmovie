package com.devsuperior.sbootdsmovie.presentation.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreRepresentationRequest implements Serializable {

    private Long movieId;
    private String email;
    private Double score;
}
