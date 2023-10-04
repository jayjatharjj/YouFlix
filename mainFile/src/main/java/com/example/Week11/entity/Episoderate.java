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
public class Episoderate {

    @Id
    private Integer episoderate_id;
    private Integer episodeid;
    private Integer userid;
    private Integer rating;
    private String review;
}
