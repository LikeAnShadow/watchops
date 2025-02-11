package de.dhge.watchops;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;



  public Movie(String title) {
    this.title = title;
  }

    public String getTitle() {
        return title;
    }
}
