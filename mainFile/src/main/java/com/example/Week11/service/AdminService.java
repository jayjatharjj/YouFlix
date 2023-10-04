package com.example.Week11.service;

import com.example.Week11.entity.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AdminService {
    ResponseEntity<Map<String,String>> addMovie(String moviename, String summary, String genre, String poster, String video, Integer runtime);
    ResponseEntity<Map<String,String>> addWebseries(String webseriesname, String poster, String summary, String genre);
    ResponseEntity<Map<String,String>> addSeason(String webseriesname, Integer seasonno);
    ResponseEntity<Map<String,String>> addEpisode(String webseriesname, Integer seasonno, Integer episodeno, String poster, String video, Integer runtime);
    ResponseEntity<List<Map<String,String>>> movieList();
    ResponseEntity<List<Map<String,String>>> webseriesList();
    ResponseEntity<List<Map<String,String>>> seasonList(String webseriesname);
    ResponseEntity<List<Map<String,String>>> episodeList(String webseriesname, Integer seasonno);
    ResponseEntity<Map<String,String>> movieDetails(String moviename);
    ResponseEntity<Map<String,String>> webseriesDetails(String webseriesname);
    ResponseEntity<Map<String,String>> seasonDetails(String webseriesname, Integer seasonno);
    ResponseEntity<Map<String,String>> episodeDetails(String webseriesname, Integer seasonno, Integer episodeno);
    ResponseEntity<Map<String,String>> editMovie(String moviename, String summary, String genre, String poster, String video, Integer runtime);
    ResponseEntity<Map<String,String>> editWebseries(String webseriesname, String poster, String summary, String genre);
    ResponseEntity<Map<String,String>> editSeason(String webseriesname, Integer seasonno);
    ResponseEntity<Map<String,String>> editEpisode(String webseriesname, Integer seasonno, Integer episodeno, String poster, String video, Integer runtime);
    ResponseEntity<Map<String,String>> deleteMovie(String moviename);
    ResponseEntity<Map<String,String>> deleteWebseries(String webseriesname);
    ResponseEntity<Map<String,String>> deleteSeason(String webseriesname, Integer seasonno);
    ResponseEntity<Map<String,String>> deleteEpisode(String webseriesname, Integer seasonno, Integer episodeno);
    ResponseEntity<Map<String,String>> dashboard();
}
