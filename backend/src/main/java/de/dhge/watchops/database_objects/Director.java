package de.dhge.watchops.database_objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String firstname;
    private String surname;
    
    public Director(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }
    public int getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
}
