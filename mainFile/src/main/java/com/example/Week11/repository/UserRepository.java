package com.example.Week11.repository;

import com.example.Week11.entity.Question;
import com.example.Week11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    public Optional<User> findByPhnno(long phoneno);
    List<User> findAllByRole(String s);
}
