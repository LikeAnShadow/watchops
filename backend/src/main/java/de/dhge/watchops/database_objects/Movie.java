package de.dhge.watchops.database_objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    @Autowired
    private MovieGenreRepository movieGenreRepository;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private int director_id;
    private int year;
    private int rating;
    private String description;
    @OneToMany(mappedBy = "movie")
    Set<MovieGenre> genres;


    public Movie(){}
    public Movie(String title, int director_id, int year, int rating, String description, List<MovieGenre> genres) {
        this.title = title;
        this.director_id = director_id;
        this.year = year;
        this.rating = rating;
        this.description = description;
        this.genres = genres;
    } // JPA needs a default constructor


    public String getTitle() {
        return title;
    }
    public int getDirector_id() {
        return director_id;
    }
    public int getYear() {
        return year;
    }
    public int getRating() {
        return rating;
    }
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public List<Integer> getGenre_ids() {
        List<Integer> genre_ids = new ArrayList<>();
        movieGenreRepository.findAllByMovieId(id).forEach(movieGenre -> {
            genre_ids.add(movieGenre.getGenre().getId());
        });
        return genre_ids;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setDescription(String description) {
        this.description = description; 
    }
    public void setGenre_ids(List<Integer> genre_ids) {
        List<MovieGenre> movieGenres = new ArrayList<>();
        genre_ids.forEach(genre_id -> {
            movieGenres.add(new MovieGenre());
        });
        this.genres = movieGenres;
    }
}
