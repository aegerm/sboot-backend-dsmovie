package com.devsuperior.sbootdsmovie.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_score")
public class Score implements Serializable {

    @EmbeddedId
    private ScoreId id = new ScoreId();
    private Double score;
}
