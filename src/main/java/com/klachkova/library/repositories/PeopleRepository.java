package com.klachkova.library.repositories;

import com.klachkova.library.modeles.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person,Integer> {
    }

