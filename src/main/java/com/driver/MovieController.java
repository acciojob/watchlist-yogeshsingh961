package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-a-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie has been added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-a-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director has been added successfully", HttpStatus.CREATED);
    }
    @PutMapping("/add-a-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Movie director pair has been added", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
        Movie movie=null;
        movie =movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);

    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){
        Director director=null;
        director= movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);

    }

    @GetMapping("/get-movie-by-director-name/{name}")
    public ResponseEntity<List<String>>  getMoviesByDirectorName(@PathVariable("name") String director){
        List<String> movies= null;
        movies=movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);

    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String>movies=null;
        movies=movieService.getAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-&itsmovies-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirectorPlusMoviesByName(director);
        return new ResponseEntity<>(director+" removed successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors-&itsmovies")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectorsPlusMovies();
        return new ResponseEntity<>("All directors are removed",HttpStatus.CREATED);
    }
}
