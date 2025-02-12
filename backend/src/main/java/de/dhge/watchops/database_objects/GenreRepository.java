package de.dhge.watchops.database_objects;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    public Genre findByName(String name);
    public void deleteByName(String name);
    public Genre findById(int id);
    
}
