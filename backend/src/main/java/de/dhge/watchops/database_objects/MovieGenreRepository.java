package de.dhge.watchops.database_objects;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieGenreRepository extends CrudRepository<MovieGenre, MovieGenreKey> {
    List<MovieGenre> findAll();

    public List<Genre> findAllByMovieId(int movieId);

    public List<Movie> findAllByGenreId(int genreId);

    public void deleteByMovieIdAndGenreId(int movieId, int genreId);

}
