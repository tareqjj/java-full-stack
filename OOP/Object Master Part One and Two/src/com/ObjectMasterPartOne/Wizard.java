package com.ObjectMasterPartOne;

public class Wizard extends Human {
    public Wizard(){
        this.setHealth(50);
        this.setIntelligence(8);
    }

    public void heal(Human h) {
        h.setHealth(this.getIntelligence());
    }

    public void fireball(Human h) {
        h.setHealth(this.getIntelligence()*3);
    }
}
