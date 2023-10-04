package com.example.Week11.repository;

import com.example.Week11.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video,String>{
    Optional<Video> findByVideolink(String s);
}
