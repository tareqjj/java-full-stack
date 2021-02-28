package com.ZooKeeperPartOne;

public class Mammal {
    private int energyLevel = 0;

    public Mammal(){
        this.energyLevel = 100;
    }

    public int displayEnergy(){
        System.out.println(this.energyLevel);
        return this.energyLevel;
    }

    public void setEnergyLevel(int levelChange){
        this.energyLevel += levelChange;

    }
}
