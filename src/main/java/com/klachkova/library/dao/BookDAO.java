package com.klachkova.library.dao;

import com.klachkova.library.modeles.Book;
import com.klachkova.library.modeles.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }


    // создан метод поиска книги по айди в боок репозитории
    // и метод поиска человека по книге в people repository
    public Integer getPerson_id(int id) {
        return jdbcTemplate.queryForObject("SELECT book.person_id FROM Book WHERE id = ?", new Object[]{id},
                Integer.class);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book ( nameOfBook, author, year) VALUES (?,?,?)",
                book.getNameOfBook(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET nameOfBook=?, author=?, year=? WHERE id =?",
                updatedBook.getNameOfBook(), updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void free(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id = null WHERE id =?", id);
    }

    public void assign(Person selectedPerson_id, int id) {
        jdbcTemplate.update("UPDATE Book SET person_id = ? WHERE id =?", selectedPerson_id, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
