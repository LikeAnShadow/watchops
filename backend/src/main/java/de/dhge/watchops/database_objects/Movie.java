package de.dhge.watchops.database_objects;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private int director_id;
    private int year;
    private int rating;
    private String description;
    private List<Long> genre_ids;


    public Movie(){}
    public Movie(String title, int director_id, int year, int rating, String description, List<Long> genre_ids) {
        this.title = title;
        this.director_id = director_id;
        this.year = year;
        this.rating = rating;
        this.description = description;
        this.genre_ids = genre_ids;
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
    public List<Long> getGenre_ids() {
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
    public void setGenre_ids(List<Long> genre_ids) {
        this.genre_ids = genre_ids;
    }
}
