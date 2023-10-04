package com.example.Week11.repository;

import com.example.Week11.entity.Poster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PosterRepository extends JpaRepository<Poster,String> {
        Optional<Poster> findByPosterimage(String s);
}
