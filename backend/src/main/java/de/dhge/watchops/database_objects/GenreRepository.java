package de.dhge.watchops.database_objects;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findAll();

    public Genre findByName(String name);
    public Genre findById(int id);
    
    public void deleteByName(String name);
    public void deleteById(int id);
    
}
