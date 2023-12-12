package com.klachkova.library.repositories;

import com.klachkova.library.models.Book;
import com.klachkova.library.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByOwner(Person owner);
    List<Book> findByNameOfBookContaining(String searchTerm);
}
