package de.dhge.watchops.database_objects;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface MovieGenreRepository extends CrudRepository<MovieGenre, Integer> {
    
    List<MovieGenre> findAllByMovieId(int movie_id);

    public MovieGenre findByMovie_id(int movie_id);
    public MovieGenre findByGenre_id(int genre_id);
    @Transactional
    public void deleteByMovie_idAndGenre_id(int movie_id, int genre_id);
    @Transactional
    public void deleteByMovie_id(int movie_id);
    @Transactional
    public void deleteByGenre_id(int genre_id);
    @Transactional
    public void deleteById(int id);

}
