package com.example.Week11.controller;

import com.example.Week11.service.AdminService;
import com.example.Week11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class



UserController {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @PostMapping("/signup")
    public ResponseEntity<Integer> signup(@RequestBody(required = false) Map<String, String> entity){

        String username = entity.get("username");
        Long phn_no = Long.valueOf(entity.get("phnno"));
        String role = entity.get("role");
        String password = entity.get("password");
        String question = entity.get("question");
        String answer = entity.get("answer");

        return userService.signup(username,phn_no,role,password,question,answer);
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login (@RequestBody(required = false) Map<String, String> entity){
        Long phn_no = Long.valueOf(entity.get("phnno"));
        String password = entity.get("password");

        return userService.login(phn_no,password);
    }
    @PostMapping("/getQuestion")
    public ResponseEntity<Map<String,String>> getQuestion (@RequestBody(required = false) Map<String, String> entity){
        Long phnno = Long.valueOf(entity.get("phnno"));
        return userService.getQuestion(phnno);
    }
    @PostMapping("/resetPassword")
    public ResponseEntity<Map<String,String>> resetPassword(@RequestBody(required = false) Map<String, String> entity){
        Long phnno = Long.valueOf(entity.get("phnno"));
        String answer = entity.get("answer");
        String password = entity.get("password");
        return userService.resetPassword(phnno,answer,password);
    }
    @GetMapping("/getMovies")
    public ResponseEntity<List<Map<String,String>>> getMovies(){
        return adminService.movieList();
    }
    @GetMapping("/getWebseries")
    public ResponseEntity<List<Map<String,String>>> getWebseries(){
        return adminService.webseriesList();
    }
    @GetMapping("/getSeasons")
    public ResponseEntity<List<Map<String,String>>> getSeasons(@RequestBody(required = false) Map<String, String> entity){
        String webseriesname = entity.get("webseriesname");
        return adminService.seasonList(webseriesname);
    }
    @GetMapping("/getEpisodes")
    public ResponseEntity<List<Map<String,String>>> getEpisodes(@RequestBody(required = false) Map<String, String> entity){
        String webseriesname = entity.get("webseriesname");
        Integer seasonno = Integer.valueOf(entity.get("seasonno"));
        return adminService.episodeList(webseriesname,seasonno);
    }
    @GetMapping("/playMovie")
    public ResponseEntity<Map<String,String>> playMovies(@RequestBody(required = false) Map<String, String> entity){
        String moviename = entity.get("moviename");
        return adminService.movieDetails(moviename);
    }
    @GetMapping("/playEpisode")
    public ResponseEntity<Map<String,String>> playEpisode(@RequestBody(required = false) Map<String, String> entity){
        String webseriesname = entity.get("webseriesname");
        Integer seasonno = Integer.valueOf(entity.get("seasonno"));
        Integer episodeno = Integer.valueOf(entity.get("episodeno"));
        return adminService.episodeDetails(webseriesname,seasonno,episodeno);
    }
}
