package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void add_movie(Movie m){

        movieRepository.add_movie(m);
    }

    public void add_director(Director d){

        movieRepository.add_director(d);
    }

    public void add_pair(String mov,String dir){
        movieRepository.pair_movie(mov, dir);
    }


    public Movie get_movie(String name){
        return movieRepository.get_movie(name);
    }
    public Director get_director(String name){
        return movieRepository.get_director(name);
    }

    public ArrayList<String> get_movie_by_name(String director) {
        return movieRepository.get_movie_bydirector(director);
    }

    public ArrayList<String> get_All() {
        return movieRepository.get_All();
    }

    public void deleteDirector(String name) {
        movieRepository.delete(name);
    }

    public void deleteAll(){
        movieRepository.deleteAll();

    }



}

