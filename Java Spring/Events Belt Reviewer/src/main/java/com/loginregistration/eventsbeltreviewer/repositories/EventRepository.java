package com.loginregistration.eventsbeltreviewer.repositories;

import com.loginregistration.eventsbeltreviewer.modles.Event;
import com.loginregistration.eventsbeltreviewer.modles.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByState(String state);
    List<Event> findAllByStateIsNot(String state);
}
