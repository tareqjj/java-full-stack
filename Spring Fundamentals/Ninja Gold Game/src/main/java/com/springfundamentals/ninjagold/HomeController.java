package com.springfundamentals.ninjagold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session){
        if (session.isNew()) {
            ArrayList<String> list = new ArrayList<String>();
            session.setAttribute("gold", 0);
            session.setAttribute("activities", list);
        }
        return "index.jsp";
    }

    @RequestMapping("/findGold")
    public String findGold(@RequestParam (value = "whichForm") String whichForm, HttpSession session) {
        session.setAttribute("whichForm", whichForm);
        if (whichForm.equals("newGame")){
            session.invalidate();
            return "redirect:/";
        }
        return "redirect:/place";
    }

    @RequestMapping("/place")
    public String place(HttpSession session) {
        Date date = new Date();
        Random rand = new Random();
        int gold = (int) session.getAttribute("gold");
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");

        switch ((String) session.getAttribute("whichForm")){
            case "farm":
                int earned = rand.nextInt(10) + 10;
                int sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                String activity = "You entered a farm and earned " + earned + " gold. (" + date + ")";
                activities.add(activity);
                session.setAttribute("activities", activities);
                break;

            case "cave":
                earned = rand.nextInt(5) + 5;
                sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                activity = "You entered a cave and earned " + earned + " gold. (" + date + ")";
                activities.add(activity);
                session.setAttribute("activities", activities);
                break;

            case "house":
                earned = rand.nextInt(3) + 2;
                sumGold = earned + gold;
                session.setAttribute("gold", sumGold);
                activity = "You entered a house and earned " + earned + " gold. (" + date + ")";
                activities.add(activity);
                session.setAttribute("activities", activities);
                break;

            case "casino":
                earned = rand.nextInt(51);
                if (rand.nextBoolean()) {
                    sumGold = earned + gold;
                    session.setAttribute("gold", sumGold);
                    activity = "You entered a casino and earned " + earned + " gold. (" + date + ")";
                } else {
                    sumGold = gold - earned;
                    session.setAttribute("gold", sumGold);
                    activity = "You entered a casino and lost " + earned + " gold. Ouch. (" + date + ")";
                }
                activities.add(activity);
                session.setAttribute("activities", activities);
                break;

            case "spa":
                earned = rand.nextInt(15) + 5;
                sumGold = gold - earned;
                session.setAttribute("gold", sumGold);
                activity = "You entered a spa and lost " + earned + " gold. Ouch. (" + date + ")";
                activities.add(activity);
                session.setAttribute("activities", activities);
                break;
        }
        if (gold < 0)
            return "prison.jsp";
        return "redirect:/";
    }
}
