package com.springdataone.relationships.controllers;

import com.springdataone.relationships.models.License;
import com.springdataone.relationships.services.LicenseService;
import com.springdataone.relationships.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LicenseController {
    private final LicenseService licenseService;
    private final PersonService personService;

    public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }

    @RequestMapping("/licenses/new")
    public String displayAddLicense(@ModelAttribute("license") License license, Model model) {
        model.addAttribute("persons", personService.allUnlicensedPersons());
        return "/licenses/newLicense.jsp";
    }

    @RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
    public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors())
            return "/licenses/newLicense.jsp";
        License newLicense = licenseService.createLicense(license);
        return  "redirect:/persons/" + newLicense.getPerson().getId();
    }

}
