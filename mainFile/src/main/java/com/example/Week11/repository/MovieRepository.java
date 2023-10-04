package com.example.Week11.repository;

import com.example.Week11.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {
    Optional<Movie> findByMoviename(String s);
}
