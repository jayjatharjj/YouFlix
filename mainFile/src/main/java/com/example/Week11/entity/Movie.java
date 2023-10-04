package com.example.Week11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    private String moviename;
    private Integer movieposterid;
    private Integer movielinkid;
    private Integer moviegenreid;
    private String moviesummary;
    private Integer movieruntime;
}
