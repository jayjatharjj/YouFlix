package com.example.Week11.service.impl;

import com.example.Week11.entity.*;
import com.example.Week11.repository.*;
import com.example.Week11.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {
    Map<String,String> response = new HashMap<>();
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    PosterRepository posterRepository;
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    WebseriesRepository webseriesRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    Movie movie;
    @Autowired
    Poster poster1;
    @Autowired
    Video video1;
    @Autowired
    Genre genre1;
    @Override
    public ResponseEntity<Map<String, String>> addMovie(String moviename, String summary, String genre, String poster, String video ,Integer runtime) {
        response.clear();
        Optional<Movie> m = movieRepository.findByMoviename(moviename);
        if(m.isPresent()){
            response.put("message","Movie already exists");
        }else{
            Optional<Poster> p = posterRepository.findByPosterimage(poster);
            Optional<Video> v = videoRepository.findByVideolink(video);
            Optional<Genre> g = genreRepository.findByGenre(genre);
            movie = Movie.builder().moviename(moviename).moviesummary(summary).movieruntime(runtime).build();
            if(g.isPresent()){
                movie.setMoviegenreid(g.get().getGenre_id());
            }else {
                genre1 = Genre.builder().genre(genre).build();
                genreRepository.save(genre1);
                movie.setMoviegenreid(genre1.getGenre_id());
            }
            if(p.isPresent()){
                movie.setMovieposterid(p.get().getPoster_id());
            }else{
                poster1 = Poster.builder().posterimage(poster).build();
                posterRepository.save(poster1);
                movie.setMovieposterid(poster1.getPoster_id());
            }
            if(v.isPresent()){
                movie.setMovielinkid(v.get().getVideo_id());
            }else{
                video1 = Video.builder().videolink(video).build();
                videoRepository.save(video1);
                movie.setMovielinkid(video1.getVideo_id());
            }
            movieRepository.save(movie);
            response.put("message","Movie added successfully");
        }
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> addWebseries(String webseriesname, String poster, String summary, String genre) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> addSeason(String webseriesname, Integer seasonno) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> addEpisode(String webseriesname, Integer seasonno, Integer episodeno, String poster, String video, Integer runtime) {
        return null;
    }

    @Override
    public ResponseEntity<List<Map<String,String>>> movieList(){
        response.clear();
        List<Movie> ml = movieRepository.findAll();
        List<Map<String,String>> l = new ArrayList<>();
        for (Movie m : ml) {
            Map<String,String> r = new HashMap<>();
            r.put("moviename",m.getMoviename());
            r.put("genre", genreRepository.findById(String.valueOf(m.getMoviegenreid())).get().getGenre());
            r.put("poster",posterRepository.findById(String.valueOf(m.getMovieposterid())).get().getPosterimage());
            l.add(r);
        }
        return ResponseEntity.ok().body(l);
    }

    @Override
    public ResponseEntity<List<Map<String, String>>> webseriesList() {
        return null;
    }

    @Override
    public ResponseEntity<List<Map<String, String>>> seasonList(String webseriesname) {
        return null;
    }

    @Override
    public ResponseEntity<List<Map<String, String>>> episodeList(String webseriesname, Integer seasonno) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String,String>> movieDetails(String moviename) {
        response.clear();
        System.out.println(moviename);
        Optional<Movie> m = movieRepository.findByMoviename(moviename);
        System.out.println(m);
        Optional<Poster> p = posterRepository.findById(String.valueOf(m.get().getMovieposterid()));
        Optional<Video> v = videoRepository.findById(String.valueOf(m.get().getMovielinkid()));
        Optional<Genre> g = genreRepository.findById(String.valueOf(m.get().getMoviegenreid()));
        response.put("moviename",m.get().getMoviename());
        response.put("summary",m.get().getMoviesummary());
        response.put("genre",g.get().getGenre());
        response.put("poster",p.get().getPosterimage());
        response.put("video",v.get().getVideolink());
        response.put("runtime", String.valueOf(m.get().getMovieruntime()));
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> webseriesDetails(String webseriesname) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> seasonDetails(String webseriesname, Integer seasonno) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> episodeDetails(String webseriesname, Integer seasonno, Integer episodeno) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> editMovie(String moviename, String summary, String genre, String poster, String video, Integer runtime) {
        response.clear();
        Optional<Movie> m = movieRepository.findByMoviename(moviename);
        Optional<Poster> p = posterRepository.findByPosterimage(poster);
        Optional<Video> v = videoRepository.findByVideolink(video);
        Optional<Genre> g = genreRepository.findByGenre(genre);
        m.get().setMoviesummary(summary);
        m.get().setMovieruntime(runtime);
        if(g.isPresent()){
            m.get().setMoviegenreid(g.get().getGenre_id());
        }else {
            genre1 = Genre.builder().genre(genre).build();
            genreRepository.save(genre1);
            m.get().setMoviegenreid(genre1.getGenre_id());
        }
        if(p.isPresent()){
            m.get().setMovieposterid(p.get().getPoster_id());
        }else{
            poster1 = Poster.builder().posterimage(poster).build();
            posterRepository.save(poster1);
            m.get().setMovieposterid(poster1.getPoster_id());
        }
        if(v.isPresent()){
            m.get().setMovielinkid(v.get().getVideo_id());
        }else{
            video1 = Video.builder().videolink(video).build();
            videoRepository.save(video1);
            m.get().setMovielinkid(video1.getVideo_id());
        }
        movieRepository.save(m.get());
        response.put("message","movie updated successfully");
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> editWebseries(String webseriesname, String poster, String summary, String genre) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> editSeason(String webseriesname, Integer seasonno) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> editEpisode(String webseriesname, Integer seasonno, Integer episodeno, String poster, String video, Integer runtime) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> dashboard() {
        List<User> ul = userRepository.findAllByRole("user");
        List<Movie> ml = movieRepository.findAll();
        List<Webseries> wl = webseriesRepository.findAll();
        Integer epCount = 0;
        for (Webseries w : wl) {
            List<Season> sl = seasonRepository.findAllByWebseriesid(w.getWebseries_id());
            for (Season s : sl) {
                List<Episode> el = episodeRepository.findAllBySeasonid(s.getSeason_id());
                epCount = epCount + el.size();
            }
        }
        response.put("userCount", String.valueOf(ul.size()));
        response.put("movieCount", String.valueOf(ml.size()));
        response.put("webseriesCount", String.valueOf(wl.size()));
        response.put("episodeCount", String.valueOf(epCount));
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteMovie(String moviename) {
        response.clear();
        Optional<Movie> m = movieRepository.findByMoviename(moviename);
        movieRepository.delete(m.get());
        response.put("message","movie deleted successfully");
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteWebseries(String webseriesname) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteSeason(String webseriesname, Integer seasonno) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteEpisode(String webseriesname, Integer seasonno, Integer episodeno) {
        return null;
    }
}
