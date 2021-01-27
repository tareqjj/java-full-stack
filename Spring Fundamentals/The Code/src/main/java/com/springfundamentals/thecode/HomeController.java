package com.springfundamentals.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public String checkCode(@RequestParam(value = "code") String code){
        if (code.equals("bushido"))
            return "redirect:/code";
        return "redirect:/displayError";
    }

    @RequestMapping("/displayError")
    public String flashMessages(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "You must train harder!");
        return "redirect:/";
    }

    @RequestMapping("/code")
    public String code(){
        return "code.jsp";
    }
}
