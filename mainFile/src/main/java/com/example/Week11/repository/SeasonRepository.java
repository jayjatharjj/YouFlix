package com.example.Week11.repository;

import com.example.Week11.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season,String> {
    List<Season> findAllByWebseriesid(Integer i);
}
