package com.springfundamentals.getting_familiar_with_routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    @RequestMapping("/{noun}")
    public String addName(@PathVariable("noun") String noun){
        if (noun.equals("burbank-dojo"))
            return "Burbank Dojo is located in Southern California";
        else if (noun.equals("san-jose"))
            return "SJ dojo is the headquarters";
        else
            return "The " + noun + " is awesome!";
    }
}
