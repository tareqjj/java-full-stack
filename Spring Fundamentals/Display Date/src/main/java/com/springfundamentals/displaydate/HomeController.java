package com.springfundamentals.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String pindex(Model model){
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
        model.addAttribute("date", dateFormatter.format(date));
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model){
        Date time = new Date();
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        model.addAttribute("time", timeFormatter.format(time));
        return "time.jsp";
    }
}
