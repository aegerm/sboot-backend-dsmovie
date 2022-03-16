package com.devsuperior.sbootdsmovie.repository;

import com.devsuperior.sbootdsmovie.domain.Score;
import com.devsuperior.sbootdsmovie.domain.ScoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScoreId> {
}
