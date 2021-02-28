package com.loginregistration.loginregistration.controllers;

import com.loginregistration.loginregistration.models.Show;
import com.loginregistration.loginregistration.models.User;
import com.loginregistration.loginregistration.models.UserShow;
import com.loginregistration.loginregistration.services.UserService;
import com.loginregistration.loginregistration.validator.ShowValidator;
import com.loginregistration.loginregistration.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final ShowValidator showValidator;

    public UserController(UserService userService, UserValidator userValidator, ShowValidator showValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.showValidator = showValidator;
    }

    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/loginRegistration/loginRegistration.jsp";
    }


    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
        userValidator.validate(user, result);
        if (result.hasErrors())
            return "/loginRegistration/loginRegistration.jsp";
        User newUser = userService.registerUser(user);
        session.setAttribute("user_id", newUser.getId() );
        return "redirect:/shows";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, @ModelAttribute("user") User user, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
        if (userService.authenticateUser(email, password)) {
            User loggedUser = userService.findByEmail(email);
            session.setAttribute("user_id", loggedUser.getId());
            return "redirect:/shows";
        } else {
            model.addAttribute("error", "Email doesn't exist or password is wrong!");
            return "/loginRegistration/loginRegistration.jsp";
        }
    }

    @RequestMapping("/shows")
    public String home(HttpSession session, Model model) {
        Long user_id = (Long) session.getAttribute("user_id");
        List<Show> showList = userService.allShows();
        List<Double> avgRating = new ArrayList<>();
        for (Show show: showList) {
            avgRating.add(userService.ratingByShow(show));
        }

        User loggedUser = userService.findUserById(user_id);
        model.addAttribute("user", loggedUser);
        model.addAttribute("shows", showList);
        model.addAttribute("avgRating", avgRating);
        return "/loginRegistration/homePage.jsp";
    }

    @RequestMapping("/shows/new")
    public String displayNewShowPage(@ModelAttribute("show") Show show, HttpSession session, Model model) {
        User loggedUser = userService.findUserById((Long) session.getAttribute("user_id"));
        model.addAttribute("loggedUser", loggedUser);
        return "/loginRegistration/newShow.jsp";
    }

    @RequestMapping(value = "/shows/new", method = RequestMethod.POST)
    public String addNewShow(@Valid @ModelAttribute("show") Show show, BindingResult result) {
        showValidator.validate(show, result);
        if (result.hasErrors())
            return "/loginRegistration/newShow.jsp";
        userService.createShow(show);
        return "redirect:/shows";
    }

    @RequestMapping("/shows/{id}")
    public String eventPage(@PathVariable("id") Long event_id, @ModelAttribute("rate") UserShow rating, HttpSession session, Model model) {
        User loggedUser = userService.findUserById((Long) session.getAttribute("user_id"));
        Show showToView = userService.findShowById(event_id);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("showToView", showToView);
        model.addAttribute("userRatings",showToView.getUserRatings());
        return "/loginRegistration/showInfo.jsp";
    }

    @RequestMapping(value = "/addRating", method = RequestMethod.POST)
    public String addRating(@ModelAttribute("rate") UserShow rate, BindingResult result) {
        if (result.hasErrors())
            return "/loginRegistration/showInfo.jsp";
        userService.createRating(rate);
        return "redirect:/shows";
    }

    @RequestMapping("/shows/{id}/edit")
    public String displayEditEvent(@PathVariable("id") Long show_id, @ModelAttribute("show") Show show, HttpSession session, Model model) {
        User loggedUser = userService.findUserById((Long) session.getAttribute("user_id"));
        Show showToEdit = userService.findShowById(show_id);
        model.addAttribute("showToEdit", showToEdit);
        return "/loginRegistration/editInfo.jsp";
    }

    @RequestMapping(value = "/shows/{id}/edit", method = RequestMethod.POST)
    public String displayEditEvent(@PathVariable("id") Long show_id,@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, Model model) {
        showValidator.validate(show, result);
        if (result.hasErrors())
            return "/loginRegistration/editInfo.jsp";
        User loggedUser = userService.findUserById((Long) session.getAttribute("user_id"));
        Show showToEdit = userService.findShowById(show_id);
        model.addAttribute("showToEdit", showToEdit);
        model.addAttribute("loggedUser", loggedUser);
        userService.updateShow(show);
        return "redirect:/shows";
    }

    @RequestMapping(value = "/destroy/{show_id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("show_id")Long event_id){
        userService.deleteShow(event_id);
        return "redirect:/shows";
    }



    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/";
    }
}
