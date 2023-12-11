package com.klachkova.library.repositories;

import com.klachkova.library.models.Book;
import com.klachkova.library.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByNameAndYear(String name, int year);

    Person findByBooks(Book book);
}

