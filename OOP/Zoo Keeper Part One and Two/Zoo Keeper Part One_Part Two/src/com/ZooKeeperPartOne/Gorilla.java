package com.ZooKeeperPartOne;

public class Gorilla extends Mammal {
    public void throwSomething(){
        System.out.println("Gorilla has thrown something");
        this.setEnergyLevel(-5);
    }

    public void eatBananas(){
        System.out.println("Gorilla ate bananas");
        this.setEnergyLevel(10);
    }

    public void climb(){
        System.out.println("Gorilla has climbed a tree");
        this.setEnergyLevel(-10);
    }
}
