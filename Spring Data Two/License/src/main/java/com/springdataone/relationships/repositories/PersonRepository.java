package com.springdataone.relationships.repositories;

import com.springdataone.relationships.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAllByLicenseIsNull();
}
