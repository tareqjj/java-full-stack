package com.loginregistration.eventsbeltreviewer.controllers;

import com.loginregistration.eventsbeltreviewer.modles.Event;
import com.loginregistration.eventsbeltreviewer.modles.Message;
import com.loginregistration.eventsbeltreviewer.modles.State;
import com.loginregistration.eventsbeltreviewer.modles.User;
import com.loginregistration.eventsbeltreviewer.services.EventsUsersServices;
import com.loginregistration.eventsbeltreviewer.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EventsController {
    private final EventsUsersServices eventsUsersServices;
    private final UserValidator userValidator;

    public EventsController(EventsUsersServices eventsUsersServices, UserValidator userValidator) {
        this.eventsUsersServices = eventsUsersServices;
        this.userValidator = userValidator;
    }

    @RequestMapping("/")
    public String loginRegistration(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("states", State.states);
        return "/events/loginRegistration.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            model.addAttribute("states", State.states);
            return "/events/loginRegistration.jsp";
        }
        User newUser = eventsUsersServices.registerUser(user);
        session.setAttribute("user_id", newUser.getId() );
        return "redirect:/events";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, @ModelAttribute("user") User user, Model model, HttpSession session) {
        if (eventsUsersServices.authenticateUser(email, password)) {
            User loggedUser = eventsUsersServices.findByEmail(email);
            session.setAttribute("user_id", loggedUser.getId());
            return "redirect:/events";
        } else {
            model.addAttribute("error", "Email doesn't exist or password is wrong!");
            model.addAttribute("states", State.states);
            return "/events/loginRegistration.jsp";
        }
    }

    @RequestMapping("/events")
    public String events(@ModelAttribute("event") Event event, HttpSession session, Model model) {
        User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("inStateEvents", eventsUsersServices.eventsInState(loggedUser.getState()));
        model.addAttribute("outStateEvents", eventsUsersServices.eventsOutState(loggedUser.getState()));
        model.addAttribute("states", State.states);
        return "/events/dashboard.jsp";
    }

    @RequestMapping(value = "/createEvent", method = RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()){
            User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
            model.addAttribute("loggedUser", loggedUser);
            model.addAttribute("inStateEvents", eventsUsersServices.eventsInState(loggedUser.getState()));
            model.addAttribute("outStateEvents", eventsUsersServices.eventsOutState(loggedUser.getState()));
            model.addAttribute("states", State.states);
            return "/events/dashboard.jsp";
        }
        eventsUsersServices.createEvent(event);
        return "redirect:/events";
    }

    @RequestMapping("/joinEvent/{id}")
    public String joinEvent(@PathVariable("id") Long event_id, HttpSession session) {
        User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
        Event eventToJoin = eventsUsersServices.findEventById(event_id);
        eventsUsersServices.userJoinEvent(loggedUser, eventToJoin);
        return "redirect:/events";
    }

    @RequestMapping("/cancel/{id}")
    public String cancelAttending(@PathVariable("id") Long event_id, HttpSession session) {
        User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
        Event eventToLeave = eventsUsersServices.findEventById(event_id);
        eventsUsersServices.userLeavesEvent(loggedUser, eventToLeave);
        return "redirect:/events";
    }

    @RequestMapping("/events/{id}/edit")
    public String displayEditEvent(@PathVariable("id") Long event_id, @ModelAttribute("event") Event event, HttpSession session, Model model) {
        User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
        Event eventToEdit = eventsUsersServices.findEventById(event_id);
        if (eventToEdit.getUserPlanner().equals(loggedUser)) {
            model.addAttribute("eventToEdit", eventToEdit);
            model.addAttribute("states", State.states);
            return "/events/eventEdit.jsp";
        }
        return "redirect:/events";
    }

    @RequestMapping(value = "/events/{id}/edit", method = RequestMethod.POST)
    public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
        if (result.hasErrors())
            return "/events/eventEdit.jsp";
        eventsUsersServices.createEvent(event);
        return "redirect:/events";
    }


    @RequestMapping("/events/{id}")
    public String eventPage(@PathVariable("id") Long event_id, @ModelAttribute("message") Message message, HttpSession session, Model model) {
        User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
        Event eventToView = eventsUsersServices.findEventById(event_id);
        List<Message> eventMessages = eventsUsersServices.eventMessages(eventToView);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("eventToView", eventToView);
        model.addAttribute("eventMessages", eventMessages);
        return "/events/eventInfo.jsp";
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.POST)
    public String eventPage(@PathVariable("id") Long event_id,@Valid @ModelAttribute("message") Message message, BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            User loggedUser = eventsUsersServices.findUserById((Long) session.getAttribute("user_id"));
            Event eventToView = eventsUsersServices.findEventById(event_id);
            List<Message> eventMessages = eventsUsersServices.eventMessages(eventToView);
            model.addAttribute("loggedUser", loggedUser);
            model.addAttribute("eventToView", eventToView);
            model.addAttribute("eventMessages", eventMessages);
            return "/events/eventInfo.jsp";
        }
        eventsUsersServices.createMessage(message);
        return "redirect:/events/" + event_id;
    }

    @RequestMapping(value = "/destroy/{event_id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("event_id")Long event_id){
        eventsUsersServices.deleteEventById(event_id);
        return "redirect:/events";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
