package com.springdataone.languages.repositories;

import com.springdataone.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    // this method retrieves all the books from the database
    List<Language> findAll();
}
