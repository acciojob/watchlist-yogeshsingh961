package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class MovieRepository {
  HashMap<String,Movie> movieHashMap=new HashMap<>();
  HashMap<String,Director> directorHashMap= new HashMap<>();
  HashMap<String, List<String>> movieDirectorHashMap= new HashMap<>();

  public void addMovie(Movie movie){
      String movieName=movie.getName();
      movieHashMap.put(movieName,movie);
  }

  public void addDirector(Director director){
      String directorName= director.getName();
      directorHashMap.put(directorName,director);
  }

  public void addMovieDirectorPair(String movie, String director){
      if(movieDirectorHashMap.containsKey(director)){
          List<String>temp=movieDirectorHashMap.get(director);
          temp.add(movie);
          movieDirectorHashMap.put(director,temp);
      }else{
          List<String> movies=new ArrayList<>();
          movies.add(movie);
          movieDirectorHashMap.put(director,movies);
      }

  }

  public Movie  getMovieByName(String movie){
      for(String mName: movieHashMap.keySet()){
          if(mName.equals(movie))
              return movieHashMap.get(movie);
      }
      return null;

  }

  public Director getDirectorByName(String director){
      for(String dName: directorHashMap.keySet()){
          if(dName.equals(director)) return directorHashMap.get(dName);
      }
      return null;
  }

  public List<String> getMoviesByDirectorName(String director){
      List<String> movies= new ArrayList<>();
      if(movieDirectorHashMap.containsKey(director)){
          return movieDirectorHashMap.get(director);
      }
      return movies;
  }

  public List<String> getAllMovies(){
      List<String> moviesList=new ArrayList<>();
      for(String mName:movieHashMap.keySet()){
          moviesList.add(mName);
      }
      return moviesList;
  }

 public void deleteDirectorPlusMoviesByName(String directorName){
      List<String> moviesList=new ArrayList<>();
      if(movieDirectorHashMap.containsKey(directorName)){
          moviesList=movieDirectorHashMap.get(directorName);
          for(String mName:moviesList){
              if(movieHashMap.containsKey(mName)){
                  movieHashMap.remove(mName);
              }
          }
          if(directorHashMap.containsKey(directorName))
              directorHashMap.remove(directorName);
          movieDirectorHashMap.remove(directorName);
      }
 }

 public void deleteAllDirectorsPlusMovies(){
      List<String>movieList= new ArrayList<>();
      for(String directorName: movieDirectorHashMap.keySet()){
          for(String mName: movieDirectorHashMap.get(directorName)){
              movieList.add(mName);
          }
      }
      for(String mName: movieList){
          if(movieHashMap.containsKey(mName)){
              movieHashMap.remove(mName);
          }
      }
      movieDirectorHashMap = new HashMap<>();

 }
}
