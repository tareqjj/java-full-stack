package com.springfundamentals.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("myName", "Tareq Aljamal");
        return "index.jsp";
    }
}
