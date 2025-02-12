package de.dhge.watchops;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import de.dhge.watchops.database_objects.Movie;
import de.dhge.watchops.database_objects.MovieRepository;

@RestController
public class EndpointController {

    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping("/movie")
    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }  

    @GetMapping("/movie/{id}")
    public Movie getMovie(int id) {
        Movie movie = movieRepository.findById(id);
        return movie;
    }


    @PostMapping("/movie") 
    public void addMovie(String title, int year, String description, int rating, int director_id, int genre_id) {
        Movie movie = new Movie(title, genre_id, director_id, year, rating, description);
        movieRepository.save(movie);
    }
    @PutMapping("/movie/{id}")
    public void updateMovie(int id, String title, int year, String description, int rating, int director_id, int genre_id) {
        Movie movie = movieRepository.findById(id);
        movie.setTitle(title);
        movie.setYear(year);
        movie.setDescription(description);
        movie.setRating(rating);
        movie.setDirector_id(director_id);
        movie.setGenre_id(genre_id);
        movieRepository.save(movie);
    }
    @DeleteMapping("/movie/{id}")
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}