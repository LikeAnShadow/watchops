package de.dhge.watchops.database_objects;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    //   @OneToMany(mappedBy = "genre")
    //Set<MovieGenre> movies;

    public Genre(String name) {
        this.name = name;
    } // JPA needs a default constructor

    public Genre() {
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    //public Set<Movie> getMovies() {
    //    return movies.stream().map(MovieGenre::getMovie).collect(Collectors.toSet());
    //}
}
