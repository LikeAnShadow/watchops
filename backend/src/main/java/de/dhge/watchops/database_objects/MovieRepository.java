package de.dhge.watchops.database_objects;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();

    Movie findByTitle(String title);
    Movie findById(int id);
    @Transactional
    void deleteById(int id);
}
