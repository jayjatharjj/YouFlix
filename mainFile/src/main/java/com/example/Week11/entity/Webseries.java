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
public class Webseries {
    @Id
    private Integer webseries_id;
    private String webseriesname;
    private Integer webseriesposterid;
    private String webseriessummary;
    private Integer webseriesgenreid;
}
