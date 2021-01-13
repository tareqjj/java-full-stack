package com.springfundamentals.counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session){
        if (session.isNew() || session.getAttribute("count") == null) {
            session.setAttribute("count", 1);
            Integer count = (Integer) session.getAttribute("count");
        } else {
            int counter = (int) session.getAttribute("count");
            counter++;
            session.setAttribute("count", counter);
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model){
        if (!session.isNew()) {
            int counter = (int) session.getAttribute("count");
            model.addAttribute("counter", counter);
            return "counter.jsp";
        } else
            return "redirect:/";
    }

    @RequestMapping("/addtwo")
    public String addTwo(HttpSession session, Model model){
        if (!session.isNew()) {
            int counter = (int) session.getAttribute("count");
            counter += 2;
            session.setAttribute("count", counter);
            model.addAttribute("counter", counter);
            return "addtwo.jsp";
        } else
            return "redirect:/"; 
    }

    @RequestMapping("/reset")
    public String reset(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
