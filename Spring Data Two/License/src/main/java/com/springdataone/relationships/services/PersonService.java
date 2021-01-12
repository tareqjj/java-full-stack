package com.springdataone.relationships.services;

import com.springdataone.relationships.models.License;
import com.springdataone.relationships.models.Person;
import com.springdataone.relationships.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allUnlicensedPersons(){
        return personRepository.findAllByLicenseIsNull();
    }

    public Person createPerson(Person p){
        return personRepository.save(p);
    }

    public Person findPerson(Long id){
        Optional<Person> personToFind = personRepository.findById(id);
        if (personToFind.isPresent())
            return personToFind.get();
        else
            return null;
    }
}
