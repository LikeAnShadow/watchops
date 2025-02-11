package de.dhge.watchops;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointController {

    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
}

}
