package com.Pokemon;

public class Pokedex extends AbstractPokemon {
    public void listPokemon(){
        for (Pokemon pokemon:myPokemons) {
            System.out.println(pokemon.getName());
        }
    }
}
