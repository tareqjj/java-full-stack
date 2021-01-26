package com.springfundamentals.hello_human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(@RequestParam(value = "q", required = false) String first_name, @RequestParam(value = "k", required = false) String last_name){
        if (first_name == null)
            return "Hello Human!";
        else if (last_name == null)
            return "Hello " + first_name;
        else
            return "Hello " + first_name +  ", " + last_name;
    }
}
