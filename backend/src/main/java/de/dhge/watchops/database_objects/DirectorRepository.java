package de.dhge.watchops.database_objects;

import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
    public Director findByFirstnameAndSurname(String firstname, String surname);
    public Director findByFirstname(String firstname);
    public Director findBySurname(String surname);
    public void deleteByFirstnameAndSurname(String firstname, String surname);
    public void deleteByFirstname(String firstname);
    public void deleteBySurname(String surname);
    
}
