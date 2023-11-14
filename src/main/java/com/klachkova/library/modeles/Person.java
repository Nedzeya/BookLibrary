package com.klachkova.library.modeles;

import javax.validation.constraints.*;

public class Person {
    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private String name;

    @Min(value = 1923, message = "A person should not be over 100 years old")
    @Max(value = 2017, message = "The person must be 6 years of age or older")
    private int year;

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
}
