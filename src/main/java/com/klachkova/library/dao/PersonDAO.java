package com.klachkova.library.dao;

import com.klachkova.library.modeles.Book;
import com.klachkova.library.modeles.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show(String name, int year) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE name=? and year=?",
                        new Object[]{name, year},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public Person show(Integer person_id) {

        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?",
                        new Object[]{person_id},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name,year) VALUES (?,?)",
                person.getName(), person.getYear());
    }

    public void update(int person_id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, year=? WHERE person_id = ?",
                updatedPerson.getName(), updatedPerson.getYear(), person_id);
    }

    public void delete(int person_id) {
        jdbcTemplate.update("DELETE FROM Person WHERE person_id=?", person_id);
    }


    public List<Book> takenBooks(int person_id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id = ?",
                new Object[]{person_id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}