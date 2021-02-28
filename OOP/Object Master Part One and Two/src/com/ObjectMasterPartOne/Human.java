package com.ObjectMasterPartOne;

public class Human {
    protected int health = 0;
    protected int strength = 0;
    protected int stealth = 0;
    protected int intelligence = 0;

    public Human(){
        this.health = 100;
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
    }

    public int getHealth() {
        System.out.println(this.health);
        return this.health;
    }

    public int getStealth(){
        return this.stealth;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setIntelligence(int intelligenceChange) {
        this.intelligence += intelligenceChange;
    }

    public void setStrength(int strengthChange) {
        this.strength += strengthChange;
    }

    public void setStealth(int stealthChange){
        this.stealth += stealthChange;
    }

    public void setHealth(int healthChange){
        this.health += healthChange;
    }

    public void attack(Human h){
        h.setHealth(-this.strength);
    }
}
