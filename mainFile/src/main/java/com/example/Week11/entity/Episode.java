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
public class Episode {

    @Id
    private Integer episode_id;
    private Integer seasonid;
    private Integer episodeno;
    private Integer episodeposterid;
    private Integer episodelinkid;
    private Integer episoderuntime;
}
