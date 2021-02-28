package com.loginregistration.eventsbeltreviewer.repositories;

import com.loginregistration.eventsbeltreviewer.modles.Event;
import com.loginregistration.eventsbeltreviewer.modles.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();
    List<Message> findAllByEvent(Event event);
}
