package com.springdataone.relationships.controllers;

import com.springdataone.relationships.models.Person;
import com.springdataone.relationships.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/persons/new")
    public String displayAddPerson(@ModelAttribute("person") Person person) {
        return "/licenses/newPerson.jsp";
    }

    @RequestMapping(value = "/persons/new", method = RequestMethod.POST)
    public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors())
            return "/licenses/newPerson.jsp";
        personService.createPerson(person);
        return "redirect:/licenses/new";
    }

    @RequestMapping("/persons/{id}")
    public String showPerson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.findPerson(id));
        return "licenses/showPerson.jsp";
    }
}
