package com.klachkova.library.repositories;

import com.klachkova.library.modeles.Book;
import com.klachkova.library.modeles.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByOwner(Person owner);
}
