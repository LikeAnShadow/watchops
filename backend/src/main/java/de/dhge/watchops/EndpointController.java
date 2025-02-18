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
import de.dhge.watchops.database_objects.MovieGenreRepository;
import de.dhge.watchops.database_objects.MovieRepository;
import de.dhge.watchops.database_objects.MovieGenre;

@RequestMapping("/api")
@RestController
public class EndpointController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private GenreRepository genreRepository;
    
    @Autowired
    private MovieGenreRepository movieGenreRepository;
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }  

    @PostMapping("/movies") 
    public Movie addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie;
    }
    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        Movie movie = movieRepository.findById(id);
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
    @GetMapping("/movies/{id}/genres")
    public List<Genre> getGenresByMovie(@PathVariable int id) {
        List<Genre> genres = movieGenreRepository.findAllByMovieId(id);
        return genres;
    }
    @PutMapping("/movies/{id}/genres")
    public void addGenreToMovie(@PathVariable int id, @RequestBody Genre genre) {
        movieGenreRepository.save(new MovieGenre(movieRepository.findById(id), genre));
    }
    @DeleteMapping("/movies/{id}/genres")
    public void removeGenreFromMovie(@PathVariable int id, @RequestBody Genre genre) {
        movieGenreRepository.deleteByMovieIdAndGenreId(id, genre.getId());
    }


    @GetMapping("/directors")
    public List<Director> getDirectors() {
        List<Director> directors = directorRepository.findAll();
        return directors;
    }
    @PostMapping("/directors")
    public Director addDirector(@RequestBody Director director) {
        directorRepository.save(director);
        return director;
    }

    @GetMapping("/directors/{id}")
    public Director getDirector(@PathVariable int id) {
        Director director = directorRepository.findById(id);
        return director;
    }
    @PutMapping("/directors/{id}")
    public Director updateDirector(@PathVariable int id, @RequestBody Director updatedDirector) {
        Director director = directorRepository.findById(id);

        director.setSurname(updatedDirector.getSurname());
        director.setFirstname(updatedDirector.getFirstname());

        return director;
    }
    @DeleteMapping("/directors/{id}")
    public void deleteDirector(@PathVariable int id) {
        directorRepository.deleteById(id);
    }


    @GetMapping("/genres")
    public List<Genre> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres;
    }
    @PostMapping("/genres")
    public Genre addGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
        return genre;
    }

    @GetMapping("/genres/{id}")
    public Genre getGenre(@PathVariable int id) {
        Genre genre = genreRepository.findById(id);
        return genre;
    }
    @PutMapping("/genres/{id}")
    public Genre updateGenre(@PathVariable int id, @RequestBody Genre updatedGenre) {
        Genre genre = genreRepository.findById(id);

        genre.setName(updatedGenre.getName());

        return genre;
    }
    @DeleteMapping("/genres/{id}")
    public void deleteGenre(@PathVariable int id) {
        genreRepository.deleteById(id);
    }
    @GetMapping("/genres/{id}/movies")
    public List<Movie> getMoviesByGenre(@PathVariable int id) {
        List<Movie> movies = movieGenreRepository.findAllByGenreId(id);
        return movies;
    }
}