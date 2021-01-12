package com.springdatatwo.dojosandninjas.controllers;

import com.springdatatwo.dojosandninjas.models.Dojo;
import com.springdatatwo.dojosandninjas.models.Ninja;
import com.springdatatwo.dojosandninjas.services.DojoNinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class DojoNinjaController {
    private final DojoNinjaService dojoNinjaService;

    public DojoNinjaController(DojoNinjaService dojoNinjaService) {
        this.dojoNinjaService = dojoNinjaService;
    }

    @RequestMapping("/dojos/new")
    public String newDojoForm(@ModelAttribute("dojo")Dojo dojo) {
        return "/dojosNinjas/newDojo.jsp";
    }

    @RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
    public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors())
            return "/dojosNinjas/newDojo.jsp";
        dojoNinjaService.createDojo(dojo);
        return "redirect:/ninjas/new";
    }

    @RequestMapping("/ninjas/new")
    public String newNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoNinjaService.allDojos());
        return "/dojosNinjas/newNinja.jsp";
    }

    @RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors())
            return "/dojosNinjas/newNinja.jsp";
        dojoNinjaService.createNinja(ninja);
        return "redirect:/dojos/" + ninja.getDojo().getId();
    }

    @RequestMapping("/dojos/{id}")
    public String displayNinjasOfDojo(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("dojo", dojoNinjaService.findDojo(id));
        model.addAttribute("ninjas", dojoNinjaService.NinjasOfDojo(id));
        return "/dojosNinjas/showPage.jsp";
    }
}
