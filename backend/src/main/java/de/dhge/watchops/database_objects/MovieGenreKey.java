package de.dhge.watchops.database_objects;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class MovieGenreKey implements Serializable {

    @Column(name = "movie_id")
    int movieId;

    @Column(name = "genre_id")
    int genreId;

    public MovieGenreKey() {
    }
    public MovieGenreKey(int movieId, int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }
    public int getMovieId() {
        return movieId;
    }
    public int getGenreId() {
        return genreId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
    // standard constructors, getters, and setters
    // hashcode and equals implementation
}