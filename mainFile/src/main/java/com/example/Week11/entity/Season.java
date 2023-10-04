package com.example.Week11.entity;

import jakarta.persistence.Entity;
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
public class Season {
    @Id
    private Integer season_id;
    private Integer seasonno;
    private Integer webseriesid;
}
