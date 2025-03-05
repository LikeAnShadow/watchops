package de.dhge.watchops.database_objects;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DirectorRepository extends CrudRepository<Director, Long> {
    List<Director> findAll();
    
    public Director findById(int id);
    public Director findByFirstnameAndSurname(String firstname, String surname);
    public Director findByFirstname(String firstname);
    public Director findBySurname(String surname);
    @Transactional
    public void deleteByFirstnameAndSurname(String firstname, String surname);
    @Transactional
    public void deleteByFirstname(String firstname);
    @Transactional
    public void deleteBySurname(String surname);
    @Transactional
    public void deleteById(int id);
}
