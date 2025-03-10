package de.dhge.watchops.database_objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String firstname;
    private String surname;
    
    public Director() {
    }
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
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
