package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void  getMovieByName(String movie){
        movieRepository. getMovieByName(movie);
    }

    public void getDirectorByName(String director){
        movieRepository.getDirectorByName(director);
    }

   public void getMoviesByDirectorName(String director){
        movieRepository.getMoviesByDirectorName(director);
   }

   public void getAllMovies(){
        movieRepository.getAllMovies();
   }

   public void deleteDirectorPlusMoviesByName(String director){
        movieRepository.deleteDirectorPlusMoviesByName(director);
   }

   public void deleteAllDirectorsPlusMovies(){
        movieRepository.deleteAllDirectorsPlusMovies();
   }


}
