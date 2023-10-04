package com.example.Week11.controller;

import com.example.Week11.entity.Movie;
import com.example.Week11.service.AdminService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/addMovie")
    public ResponseEntity<Map<String,String>> addMovie(@RequestBody(required = false) Map<String, String> entity){
        String moviename = entity.get("moviename");
        String summary = entity.get("summary");
        String genre = entity.get("genre");
        String poster = entity.get("poster");
        String video = entity.get("video");
        Integer runtime = Integer.valueOf(entity.get("runtime"));
        return adminService.addMovie(moviename,summary,genre,poster,video,runtime);
    }
    @GetMapping("/getMovieList")
    public ResponseEntity<List<Map<String,String>>> movieList(){
        return adminService.movieList();
    }
    @PostMapping("/getMovieDetails")
    public ResponseEntity<Map<String,String>> movieDetails(@RequestParam Map<String,String> moviename){
        String movie = moviename.get("moviename");
        return adminService.movieDetails(movie);
    }
    @PostMapping("/editMovie")
    public ResponseEntity<Map<String,String>> editMovie(@RequestBody(required = false) Map<String, String> entity){
        String moviename = entity.get("moviename");
        String summary = entity.get("summary");
        String genre = entity.get("genre");
        String poster = entity.get("poster");
        String video = entity.get("video");
        Integer runtime = Integer.valueOf(entity.get("runtime"));
        return adminService.editMovie(moviename,summary,genre,poster,video,runtime);
    }
    @DeleteMapping("/deleteMovie")
    public ResponseEntity<Map<String,String>> deleteMovie(@RequestBody(required = false) Map<String, String> entity) {
        String moviename = entity.get("moviename");
        return adminService.deleteMovie(moviename);
    }
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String,String>> dashboard(){
        return adminService.dashboard();
    }
    @PostMapping("/addWebseries")
    public ResponseEntity<Map<String,String>> addWebseries(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @PostMapping("/addSeason")
    public ResponseEntity<Map<String,String>> addSeason(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @PostMapping("/addEpisode")
    public ResponseEntity<Map<String,String>> addEpisode(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @GetMapping("/getWebseriesList")
    public ResponseEntity<List<Map<String,String>>> webseriesList(){
        return null;
    }
    @GetMapping("/getSeasonList")
    public ResponseEntity<List<Map<String,String>>> seasonList(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @GetMapping("/getEpisodeList")
    public ResponseEntity<List<Map<String,String>>> episodeList(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @PostMapping("/getWebseriesDetails")
    public ResponseEntity<Map<String,String>> webseriesDetails(@RequestParam Map<String,String> moviename){
        return null;
    }
    @PostMapping("/getSeasonDetails")
    public ResponseEntity<Map<String,String>> seriesDetails(@RequestParam Map<String,String> moviename){
        return null;
    }
    @PostMapping("/getEpisodeDetails")
    public ResponseEntity<Map<String,String>> episodeDetails(@RequestParam Map<String,String> moviename){
        return null;
    }
    @PostMapping("/editWebseries")
    public ResponseEntity<Map<String,String>> editWebseries(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @PostMapping("/editSeason")
    public ResponseEntity<Map<String,String>> editSeason(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @PostMapping("/editEpisode")
    public ResponseEntity<Map<String,String>> editEpisode(@RequestBody(required = false) Map<String, String> entity){
        return null;
    }
    @DeleteMapping("/deleteWebseries")
    public ResponseEntity<Map<String,String>> deleteWebseries(@RequestBody(required = false) Map<String, String> entity) {
        return null;
    }
    @DeleteMapping("/deleteSeason")
    public ResponseEntity<Map<String,String>> deleteSeason(@RequestBody(required = false) Map<String, String> entity) {
        return null;
    }
    @DeleteMapping("/deleteEpisode")
    public ResponseEntity<Map<String,String>> deleteEpisode(@RequestBody(required = false) Map<String, String> entity) {
        return null;
    }
}
