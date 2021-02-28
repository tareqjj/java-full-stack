package com.ZooKeeperPartOne;

public class Bat extends Mammal {
    public Bat(){
        this.setEnergyLevel(200);
    }

    public void fly(){
        System.out.println("Bat taking off");
        this.setEnergyLevel(-50);
    }

    public void eatHumans(){
        System.out.println("Bat eats humans");
        this.setEnergyLevel(25);
    }

    public void attackTown(){
        System.out.println("Bat attacks town");
        this.setEnergyLevel(-100);
    }
}
