package com.loginregistration.eventsbeltreviewer.repositories;

import com.loginregistration.eventsbeltreviewer.modles.Event;
import com.loginregistration.eventsbeltreviewer.modles.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEventsAttendedByUsersContaining(Event event);
    User findByEmail(String email);
}
