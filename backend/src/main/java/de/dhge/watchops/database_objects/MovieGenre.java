package de.dhge.watchops.database_objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class MovieGenre {

    @EmbeddedId
    MovieGenreKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    Genre genre;
    
    public MovieGenre() {
    }
    public MovieGenre(Movie movie, Genre genre) {
        this.movie = movie;
        this.genre = genre;
        this.id = new MovieGenreKey(movie.getId(), genre.getId());
    }
    public Movie getMovie() {
        return movie;
    }
    public Genre getGenre() {
        return genre;
    }
    public MovieGenreKey getId() {
        return id;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}