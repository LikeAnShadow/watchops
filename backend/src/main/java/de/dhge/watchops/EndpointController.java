package de.dhge.watchops;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.dhge.watchops.database_objects.Director;
import de.dhge.watchops.database_objects.DirectorRepository;
import de.dhge.watchops.database_objects.Genre;
import de.dhge.watchops.database_objects.GenreRepository;
import de.dhge.watchops.database_objects.Movie;
import de.dhge.watchops.database_objects.MovieRepository;

@RequestMapping("/api")
@RestController
public class EndpointController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private GenreRepository genreRepository;
    
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }  

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        Movie movie = movieRepository.findById(id);
        return movie;
    }


    @PostMapping("/movies") 
    public Movie addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie;
    }
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.findById(id);
        
        movie.setTitle(updatedMovie.getTitle());
        movie.setYear(updatedMovie.getYear());
        movie.setDescription(updatedMovie.getDescription());
        movie.setRating(updatedMovie.getRating());
        movie.setDirector_id(updatedMovie.getDirector_id());
        movieRepository.save(movie);
        return movie;
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
    @GetMapping("/directors")
    public List<Director> getDirectors() {
        List<Director> directors = directorRepository.findAll();
        return directors;
    }
    @GetMapping("/genres")
    public List<Genre> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres;
    }
}