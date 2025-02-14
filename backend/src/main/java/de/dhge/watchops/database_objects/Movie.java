package de.dhge.watchops.database_objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

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

        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
        @JoinTable(name = "MovieGenre", joinColumns = @JoinColumn(name = "movie_id"),  inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;


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
}
