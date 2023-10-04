package com.example.Week11.repository;

import com.example.Week11.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository extends JpaRepository<Episode,String> {
    List<Episode> findAllBySeasonid(Integer i);
}
