package com.example.Week11.repository;

import com.example.Week11.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,String> {
        Optional<Genre> findByGenre(String s);
}
