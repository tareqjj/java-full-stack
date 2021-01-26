package com.springfundamentals.ninjagold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", "");
        }
        return "index.jsp";
    }

    @RequestMapping("/findGold")
    public String findGold(@RequestParam(value = "whichForm") String whichForm, HttpSession session) {
        session.setAttribute("whichForm", whichForm);
        if (whichForm.equals("newGame")) {
            session.invalidate();
            return "redirect:/";
        }
        return "redirect:/place";
    }

    @RequestMapping("/place")
    public String place(HttpSession session) {
        String whichForm = (String) session.getAttribute("whichForm");

        Date date = new Date();
        int gold = (int) session.getAttribute("gold");
        Random rand = new Random();
        String activities = (String) session.getAttribute("activities");
        switch (whichForm) {
            case "farm":
                int earned = rand.nextInt(11) + 10;
                int sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                String activity = activities + "You entered a farm and earned " + earned + " gold. (" + date + ")</br>";
                session.setAttribute("activities", activity);
                break;

            case "cave":
                earned = rand.nextInt(6) + 5;
                sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                activity = activities + "You entered a cave and earned " + earned + " gold. (" + date + ")</br>";
                session.setAttribute("activities", activity);
                break;

            case "house":
                earned = rand.nextInt(4) + 2;
                sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                activity = activities + "You entered a house and earned " + earned + " gold. (" + date + ")</br>";
                session.setAttribute("activities", activity);
                break;

            case "casino":
                earned = rand.nextInt(50)*(rand.nextBoolean()?-1:1);
                if (earned>0){
                    activity= activities + "You entered a casino and earned " + earned + " gold. (" + date + ")</br>";
                } else {
                    activity = activities +"<span>You entered a casino and lost " + earned * -1 + " gold. (" + date + ")</br></span>";
                }
                session.setAttribute("activities", activity);
                break;

            case "spa":
                earned = rand.nextInt(15) + 5;
                sumGold = gold - earned;
                session.setAttribute("gold", sumGold);
                activity = activities + "<span> You entered a spa and lost " + earned + " gold. Ouch. (" + date + ")</br></span>";
                session.setAttribute("activities", activity);
                break;
        }
        if (gold < 0)
            return "prison.jsp";
        return "redirect:/";
    }

}
