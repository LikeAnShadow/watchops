package de.dhge.watchops.database_objects;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findAll();

    public Genre findByName(String name);
    public Genre findById(int id);
    @Transactional
    public void deleteByName(String name);
    @Transactional
    public void deleteById(int id);
    
}
