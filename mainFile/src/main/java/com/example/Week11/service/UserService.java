package com.example.Week11.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

    ResponseEntity<Integer> signup(String username, Long phn_no, String role, String password, String question, String answer);
    ResponseEntity<Map<String,String>> login(Long phn_no, String password);
    ResponseEntity<Map<String,String>> getQuestion(Long phnno);
    ResponseEntity<Map<String,String>> resetPassword(Long phnno, String answer, String password);
    ResponseEntity<Map<String,String>> rateMovie(Long phnno, String moviename, Integer rating, String review);
    ResponseEntity<Map<String,String>> rateWebseries(Long phnno, String webseriesname, Integer rating, String review);
    ResponseEntity<Map<String,String>> rateEpisode(Long phnno, String webseriesname, Integer seasonno, Integer episode, Integer rating, String review);
}
