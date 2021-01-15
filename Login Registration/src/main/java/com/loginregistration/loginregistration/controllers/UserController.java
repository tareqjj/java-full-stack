package com.loginregistration.loginregistration.controllers;

import com.loginregistration.loginregistration.models.User;
import com.loginregistration.loginregistration.services.UserService;
import com.loginregistration.loginregistration.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/loginRegistration/registrationPage.jsp";
    }

    @RequestMapping("/login")
    public String login() {
        return "/loginRegistration/loginPage.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
        userValidator.validate(user, result);
        if (result.hasErrors())
            return "/loginRegistration/registrationPage.jsp";
        User newUser = userService.registerUser(user);
        session.setAttribute("user_id", newUser.getId() );
        return "redirect:/home";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
        if (userService.authenticateUser(email, password)) {
            User loggedUser = userService.findByEmail(email);
            session.setAttribute("user_id", loggedUser.getId());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Email doesn't exist or password is wrong!");
            return "/loginRegistration/loginPage.jsp";
        }
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
        Long user_id = (Long) session.getAttribute("user_id");
        User loggedUser = userService.findUserById(user_id);
        model.addAttribute("user", loggedUser);
        return "/loginRegistration/homePage.jsp";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/login";
    }
}
