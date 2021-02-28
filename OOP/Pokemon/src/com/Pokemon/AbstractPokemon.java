package com.Pokemon;
import java.util.ArrayList;

public abstract class AbstractPokemon implements PokemonInterface {
    protected ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();

    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon newPokemon = new Pokemon(name, health, type);
        myPokemons.add(newPokemon);
        return newPokemon;
    }

    public String pokemonInfo(Pokemon pokemon){
        String str = pokemon.getName() + ", " + pokemon.getHealth() + ", " + pokemon.getType();
        return str;
    }
}
