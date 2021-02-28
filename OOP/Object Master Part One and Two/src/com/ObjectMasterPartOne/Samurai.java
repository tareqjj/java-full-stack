package com.ObjectMasterPartOne;

public class Samurai extends Human {
    private int numOfSamurai = 0;

    public Samurai() {
        this.setHealth(200);
        this.numOfSamurai += 1;
    }

    public void deathBlow(Human h) {
        h.setHealth(0);
        this.setHealth(this.getHealth()/2);
    }

    public void meditate() {
        this.setHealth(this.getHealth()/2);
    }

    public int howMany() {
        return this.numOfSamurai;
    }
}
