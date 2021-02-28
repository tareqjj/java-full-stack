package com.loginregistration.loginregistration.repositories;

import com.loginregistration.loginregistration.models.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show, Long> {
    List<Show> findAll();
    Show findByTitle(String title);
}
