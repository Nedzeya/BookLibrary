package com.klachkova.library.services;

import com.klachkova.library.modeles.Book;
import com.klachkova.library.modeles.Person;
import com.klachkova.library.repositories.PeopleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    //index
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne (int id){
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    // метод для поиска человека по имени и году  ( кастомный)
    public Optional<Person> findOne (String name, int year){
        return peopleRepository.findByNameAndYear(name,year);
    }
    // метод для поиска человека по книге
    public Person findByBook (Book book) {
        return peopleRepository.findByBook(book);
    }


    @Transactional
    public void save (Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update (int id, Person updatedPerson){
        updatedPerson.setPerson_id(id); // указываем, чтобы у измененного человека был тот же айди, тогда sava человека перезапишет
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete (int id){
        peopleRepository.deleteById(id);
    }

}
