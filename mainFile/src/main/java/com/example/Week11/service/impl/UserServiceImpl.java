package com.example.Week11.service.impl;

import com.example.Week11.entity.Movie;
import com.example.Week11.entity.Question;
import com.example.Week11.entity.User;
import com.example.Week11.repository.*;
import com.example.Week11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    Map<String,String> response = new HashMap<>();
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    PosterRepository posterRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    User user;
    @Override
    public ResponseEntity<Integer> signup(String username, Long phn_no, String role, String password, String question, String answer) {

        if (userRepository.findByPhnno(phn_no).isPresent()){
            return ResponseEntity.ok().body(2);
        }
        Optional<Question> ques = questionRepository.findByQuestion(question);
        System.out.println(username);
        user = User.builder().username(username).phnno(phn_no).role(role).password(password).quesid(ques.get().getQuestion_id()).answer(answer).islogged(Boolean.FALSE).build();
        userRepository.save(user);

        return  ResponseEntity.ok().body(1);
    }
    @Override
    public ResponseEntity<Map<String, String>> login(Long phn_no, String password) {
        response.clear();
        if (userRepository.findByPhnno(phn_no).isEmpty()){
            response.put("message","User does not exists");
            return ResponseEntity.ok().body(response);
        }else{
            Optional<User> u = userRepository.findByPhnno(phn_no);
            if(u.get().getIslogged()){
                response.put("message","User already logged in");
            }else {
                if(u.get().getPassword().equals(password)){
                    u.get().setIslogged(Boolean.TRUE);
                    userRepository.save(u.get());
                    response.put("message","User successfully logged in");
                }else {
                    response.put("message","Password incorrect");
                }
            }
        }
        return ResponseEntity.ok().body(response);
    }
    @Override
    public ResponseEntity<Map<String, String>> getQuestion(Long phnno){
        response.clear();
        Optional<User> u = userRepository.findByPhnno(phnno);
        if (u.isEmpty()){
            response.put("message","user does not exists");
        }else{
            Optional<Question> q = questionRepository.findById(String.valueOf(u.get().getQuesid()));
            response.put("message",q.get().getQuestion());
        }
        return ResponseEntity.ok().body(response);
    }
    @Override
    public ResponseEntity<Map<String, String>> resetPassword(Long phnno, String answer, String password) {
        response.clear();
        Optional<User> u = userRepository.findByPhnno(phnno);
        if (u.isEmpty()){
            response.put("message","user does not exists");
        }else{
            if(u.get().getAnswer().equals(answer)){
                u.get().setPassword(password);
                userRepository.save(u.get());
                response.put("message","Password changed successfully");
            }else {
                response.put("message","incorrect answer");
            }
        }
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> rateMovie(Long phnno, String moviename, Integer rating, String review) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> rateWebseries(Long phnno, String webseriesname, Integer rating, String review) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> rateEpisode(Long phnno, String webseriesname, Integer seasonno, Integer episode, Integer rating, String review) {
        return null;
    }
}
