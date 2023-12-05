package com.klachkova.library.repositories;

import com.klachkova.library.modeles.Book;
import com.klachkova.library.modeles.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByNameAndYear(String name, int year);

    Person findByBook(Book book);
}

