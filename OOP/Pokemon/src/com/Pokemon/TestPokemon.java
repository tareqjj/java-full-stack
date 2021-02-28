package com.Pokemon;

public class TestPokemon {
    public static void main(String[] args){
        Pokemon pokemon1 = new Pokemon("pikachu", 100,"electric");
        Pokemon pokemon2 = new Pokemon("somePokemon", 100,"fiery");
        pokemon1.attackPokemon(pokemon2);
        System.out.println(pokemon2.getHealth());
    }
}
