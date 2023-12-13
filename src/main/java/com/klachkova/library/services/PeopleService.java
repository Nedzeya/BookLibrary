package com.klachkova.library.services;

import com.klachkova.library.models.Book;
import com.klachkova.library.models.Person;
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


    public Optional<Person> findOne (String name, int year){
        return peopleRepository.findByNameAndYear(name,year);
    }

    public Person findByBook (Book book) {
        return peopleRepository.findByBooks(book);
    }


    @Transactional
    public void save (Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update (int id, Person updatedPerson){
        updatedPerson.setPerson_id(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete (int id){
        peopleRepository.deleteById(id);
    }

}
