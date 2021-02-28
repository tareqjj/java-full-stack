package com.springfundamentals.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/formProcess")
    public String formProcess(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "language") String language,
            @RequestParam(value = "comment") String comment,
            HttpSession session
    ) {
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
        if (session.getAttribute("language").equals("Java"))
            return "redirect:/java";
        return "redirect:/result";
    }

    @RequestMapping("/result")
    public String result() {
        return "result.jsp";
    }

    @RequestMapping("/java")
    public String java() {
        return "java.jsp";
    }
}
