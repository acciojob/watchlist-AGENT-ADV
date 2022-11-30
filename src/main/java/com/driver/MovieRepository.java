package com.driver;

        import java.util.*;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Repository;

@Repository
@Component
public class MovieRepository
{

    @Autowired
    Movie mov;

    @Autowired
    Director dir;

    Map<String, Movie> map_movie = new HashMap<>();
    Map<String, Director> map_director = new HashMap<>();
    Map<String, String> map_director_movie = new HashMap<>();

    public void add_movie(Movie m) {
        map_movie.put(m.getName(), m);
    }

    public void add_director(Director d) {
        map_director.put(d.getName(), d);
    }

    public void pair_movie(String m, String d) {
        map_director_movie.put(m, d);
    }

    public Movie get_movie(String name) {
        return map_movie.get(name);
    }

    public Director get_director(String name) {
        return map_director.get(name);
    }

    public ArrayList<String> get_movie_bydirector(String director) {
        ArrayList<String> ans = new ArrayList<>();
        for (String s : map_director_movie.keySet()) {
            if (map_director_movie.get(s).equalsIgnoreCase(director))
                ans.add(s);
        }
        return ans;
    }

    public ArrayList<String> get_All() {
        ArrayList<String> list = new ArrayList<>();
        for (String s : map_movie.keySet())
            list.add(s);
        return list;
    }

    public void delete(String name) {
        map_director.remove(name);
        for (String s : map_director_movie.keySet()) {
            if (map_director_movie.get(s).equalsIgnoreCase(name)) {
                map_movie.remove(s);
                map_director_movie.remove(s);
            }
        }
    }

    public void deleteAll() {
        for (String s : map_director_movie.keySet()) {

            map_movie.remove(s);
        }
        map_director_movie = new HashMap<>();
        map_director = new HashMap<>();
    }

}