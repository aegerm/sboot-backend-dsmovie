package com.devsuperior.sbootdsmovie.repository;

import com.devsuperior.sbootdsmovie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
