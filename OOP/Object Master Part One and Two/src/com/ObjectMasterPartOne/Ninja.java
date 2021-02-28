package com.ObjectMasterPartOne;

public class Ninja extends Human {

    public Ninja(){
        this.setHealth(100);
        this.setStealth(10);
    }

    public void steal(Human h){
        h.setHealth(-this.getStealth());
        this.setHealth(this.getStealth());
    }

    public void runAway(){
        this.setHealth(-10);
    }
}
