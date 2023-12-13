package com.klachkova.library.services;

import com.klachkova.library.models.Book;
import com.klachkova.library.models.Person;
import com.klachkova.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // index
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    // findAllByString
    public List<Book> findAll(String searchTeam) {

        return booksRepository.findByNameOfBookContainingIgnoreCaseOrAuthorContainingIgnoreCase(searchTeam, searchTeam);

    }
    // show by id

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    public List<Book> findByOwner(Person owner) {
        List<Book> books = booksRepository.findByOwner(owner);
        for (Book book : books) {
            overdue(book);
        }
        return books;
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }


    @Transactional
    public void free(int id) {
        Book currentBook = findOne(id);
        currentBook.setOwner(null);
        currentBook.setId(id);
        currentBook.setAssignTime(null);

        booksRepository.save(currentBook);
    }


    @Transactional
    public void assign(Person person, int id) {
        Book currentBook = findOne(id);
        currentBook.setOwner(person);
        currentBook.setId(id);
        currentBook.setAssignTime(new Date());

        booksRepository.save(currentBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    //checking whether a book is overdue
    public void overdue(Book book) {
        Duration duration = Duration.between(book.getAssignTime().toInstant(), new Date().toInstant());
        book.setOverdue(duration.toDays() >= 10);
        booksRepository.save(book);
    }


}
