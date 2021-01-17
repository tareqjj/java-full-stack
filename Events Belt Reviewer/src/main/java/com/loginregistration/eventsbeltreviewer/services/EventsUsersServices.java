package com.loginregistration.eventsbeltreviewer.services;

import com.loginregistration.eventsbeltreviewer.modles.Event;
import com.loginregistration.eventsbeltreviewer.modles.Message;
import com.loginregistration.eventsbeltreviewer.modles.User;
import com.loginregistration.eventsbeltreviewer.repositories.EventRepository;
import com.loginregistration.eventsbeltreviewer.repositories.MessageRepository;
import com.loginregistration.eventsbeltreviewer.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventsUsersServices {
    private final EventRepository eventRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public EventsUsersServices(EventRepository eventRepository, MessageRepository messageRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find user by id
    public User findUserById(Long id) {
        Optional<User> userToFind = userRepository.findById(id);
        return userToFind.orElse(null);
    }

    public void userJoinEvent(User user, Event event) {
        List<Event> eventsToAttend = user.getEventsAttendedByUsers();
        if (eventsToAttend == null)
            eventsToAttend = new ArrayList<Event>();
        eventsToAttend.add(event);
        user.setEventsAttendedByUsers(eventsToAttend);
        userRepository.save(user);
    }

    public void userLeavesEvent(User user, Event event) {
        List<Event> eventsToAttend = user.getEventsAttendedByUsers();
        eventsToAttend.remove(event);
        user.setEventsAttendedByUsers(eventsToAttend);
        userRepository.save(user);
    }

    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if (user == null)
            return false;
        else
            // if the passwords match, return true, else, return false
            return BCrypt.checkpw(password, user.getPassword());
    }

    public List<User> usersAttendingEvent(Event event) {
        return userRepository.findByEventsAttendedByUsersContaining(event);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        event.setName(event.getName());
        event.setDate(event.getDate());
        event.setLocation(event.getLocation());
        event.setState(event.getState());
        return eventRepository.save(event);
    }

    public List<Event> eventsInState(String state) {
        return eventRepository.findAllByState(state);
    }

    public List<Event> eventsOutState(String state) {
        return eventRepository.findAllByStateIsNot(state);
    }

    public Event findEventById(Long id) {
        Optional<Event> eventToFind = eventRepository.findById(id);
        return eventToFind.orElse(null);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    public Message createMessage(Message message) {
        Message newMessage = new Message(message.getComment(), message.getUserAuthor(), message.getEvent());
        return messageRepository.save(newMessage);
    }

    public List<Message> allMessages() {
        return messageRepository.findAll();
    }

    public List<Message> eventMessages(Event event) {
        return messageRepository.findAllByEvent(event);
    }






}
