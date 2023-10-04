package com.example.Week11.repository;

import com.example.Week11.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,String> {
    public Optional<Question> findByQuestion(String question);

}
