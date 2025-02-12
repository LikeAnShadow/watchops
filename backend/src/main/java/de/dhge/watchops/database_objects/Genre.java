package de.dhge.watchops.database_objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    public Genre(String name) {
        this.name = name;
    } // JPA needs a default constructor


    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
