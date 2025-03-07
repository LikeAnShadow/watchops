package de.dhge.watchops.database_objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class MovieGenreId implements java.io.Serializable {
    
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "genre_id")
    private Integer genreId;
}
