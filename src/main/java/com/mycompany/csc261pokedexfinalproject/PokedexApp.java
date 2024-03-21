/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csc261pokedexfinalproject;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.utils.Client;
import javax.swing.JOptionPane;

/**
 *
 * @author Cam
 */

public class PokedexApp {

    public static int id;
        
    public static Pokemon fetchPokemonDetailsByName (String pokemonName) {
        try {
            // Uses pokemonName
            pokemonName =  pokemonName.strip();
            return Client.getPokemonByName(pokemonName.toLowerCase());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pokemon not found.", "Error Title", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static Pokemon fetchPokemonDetailsById(int currentPokemonIndex) {
        try {
           // Uses currentPokemonIndex
           return Client.getPokemonById(currentPokemonIndex);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Pokemon ID not found.", "Error Title", JOptionPane.ERROR_MESSAGE);
           return null;
       }
    }

    public static void main(String[] args) {
        NamedAPIResourceList list = Client.getPokemonList(10, 0);
        System.out.println(list.getResults().get(0));
    }
}
