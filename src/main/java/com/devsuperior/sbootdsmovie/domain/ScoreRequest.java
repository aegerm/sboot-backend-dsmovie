package com.devsuperior.sbootdsmovie.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreRequest implements Serializable {

    private Long movieId;
    private String email;
    private Double score;
}
