package com.klachkova.library.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name of the book should not be empty")
    @Size(min = 1, max = 100, message = "Name of the book should be between 1 and 100 characters")
    @Column(name = "name_of_book")
    private String nameOfBook;

    @Size(min = 0, max = 50, message = "The author's name must not exceed 50 characters")
    @Column(name = "author")
    private String author;

    @Min(value = 1000, message = "The year must be in the format: 1234")
    @Max(value = 9999, message = "The year must be in the format: 1234")
    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person owner;

    //время назначения книги
    @Column(name= "assign_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignTime;

    @Transient
    private boolean overdue;

    public Book() {
    }

    public Book( String nameOfBook, String author, int year) {
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }


}
