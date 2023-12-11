package com.klachkova.library.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table (name = "Person")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 1923, message = "A person should not be over 100 years old")
    @Max(value = 2017, message = "The person must be 6 years of age or older")
    @Column(name = "year")
    private int year;

    @OneToMany (mappedBy = "owner")
    private List<Book> books;

    public Person() {
    }

    public Person( String name, int year) {
        this.name = name;
        this.year = year;

    }


    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
