package com.klachkova.library.repositories;

import com.klachkova.library.modeles.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book,Integer> {
}
