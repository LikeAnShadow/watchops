package de.dhge.watchops;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();
}
