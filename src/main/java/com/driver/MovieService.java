package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie,director);
    }

    public Movie  getMovieByName(String movie){
       return movieRepository.getMovieByName(movie);
    }

    public Director getDirectorByName(String director){
        return movieRepository.getDirectorByName(director);
    }

   public List<String> getMoviesByDirectorName(String director){
        return movieRepository.getMoviesByDirectorName(director);
   }

   public List<String> getAllMovies(){
        return movieRepository.getAllMovies();
   }

   public void deleteDirectorPlusMoviesByName(String director){
        movieRepository.deleteDirectorPlusMoviesByName(director);
   }

   public void deleteAllDirectorsPlusMovies(){
        movieRepository.deleteAllDirectorsPlusMovies();
   }


}
