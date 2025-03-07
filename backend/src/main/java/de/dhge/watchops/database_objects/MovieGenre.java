package de.dhge.watchops.database_objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_genre")
public class MovieGenre {
    @EmbeddedId
    private MovieGenreId id;

    public MovieGenre() {
    }
    public MovieGenre(MovieGenreId id) {
        this.id = id;
    }
    public MovieGenreId getId() {
        return id;
    }
    public void setId(MovieGenreId id) {
        this.id = id;
    }


    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;
    
    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
