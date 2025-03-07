package de.dhge.watchops;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.dhge.watchops.database_objects.MovieGenre;
import jakarta.transaction.Transactional;

public interface MovieGenreRepository extends CrudRepository<MovieGenre, Long> {
    
    List<MovieGenre> findAllByMovieId(Long movie_id);

    public MovieGenre findByMovie_id(Long movie_id);
    public MovieGenre findByGenre_id(Long genre_id);
    @Transactional
    public void deleteByMovie_idAndGenre_id(Long movie_id, Long genre_id);
    @Transactional
    public void deleteByMovie_id(Long movie_id);
    @Transactional
    public void deleteByGenre_id(Long genre_id);
    @Transactional
    public void deleteById(int id);

}
