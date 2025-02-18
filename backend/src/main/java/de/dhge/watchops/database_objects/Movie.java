package de.dhge.watchops.database_objects;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private int director_id;
    private int year;
    private int rating;
    private String description;

    //@OneToMany(mappedBy = "movie")
    //Set<MovieGenre> genres;


    public Movie(){}
    public Movie(String title, int director_id, int year, int rating, String description){
        this.title = title;
        this.director_id = director_id;
        this.year = year;
        this.rating = rating;
        this.description = description;
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
    //public Set<Genre> getGenres() {
    //    return genres.stream().map(MovieGenre::getGenre).collect(Collectors.toSet());
    //}
}
