/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc261pokedexfinalproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Cameron
 */
public class TypeEffectiveness {
    
    private static final HashMap<String, List<String>> strengths = new HashMap<>();
    private static final HashMap<String, List<String>> weaknesses = new HashMap<>();
    private static final HashMap<String, List<String>> immunities = new HashMap<>();
    private static final HashMap<String, List<String>> resistances = new HashMap<>();

    static {
        // Entire Pokemon type chart

        //Normal
        strengths.put("normal", Arrays.asList("None"));
        weaknesses.put("normal", Arrays.asList("Fighting"));
        immunities.put("normal", Arrays.asList("Ghost"));
        resistances.put("normal", Arrays.asList("None"));

        //Fire
        strengths.put("fire", Arrays.asList("Grass", "Ice", "Bug", "Steel"));
        weaknesses.put("fire", Arrays.asList("Water", "Ground", "Rock"));
        immunities.put("fire", Arrays.asList()); //Pokemon types with no immunities are labeled blank in the specific JList
        resistances.put("fire", Arrays.asList("Fire", "Grass", "Ice", "Bug", "Steel", "Fairy"));

        //Water
        strengths.put("water", Arrays.asList("Fire", "Ground", "Rock"));
        weaknesses.put("water", Arrays.asList("Grass", "Electric"));
        immunities.put("water", Arrays.asList());
        resistances.put("water", Arrays.asList("Fire", "Water", "Ice", "Steel"));

        //Grass
        strengths.put("grass", Arrays.asList("Water", "Ground", "Rock"));
        weaknesses.put("grass", Arrays.asList("Fire", "Ice", "Bug", "Flying", "Poison"));
        immunities.put("grass", Arrays.asList());
        resistances.put("grass", Arrays.asList("Water", "Electric", "Grass", "Ground"));

        //Electric
        strengths.put("electric", Arrays.asList("Water", "Flying"));
        weaknesses.put("electric", Arrays.asList("Ground"));
        immunities.put("electric", Arrays.asList());
        resistances.put("electric", Arrays.asList("Electric", "Flying", "Steel"));

        //Ice
        strengths.put("ice", Arrays.asList("Grass", "Flying", "Ground", "Dragon"));
        weaknesses.put("ice", Arrays.asList("Fire", "Fighting", "Steel", "Rock"));
        immunities.put("ice", Arrays.asList());
        resistances.put("ice", Arrays.asList("Ice"));

        //Fighting
        strengths.put("fighting", Arrays.asList("Normal", "Rock", "Dark", "Steel"));
        weaknesses.put("fighting", Arrays.asList("Flying", "Psychic", "Fairy"));
        immunities.put("fighting", Arrays.asList());
        resistances.put("fighting", Arrays.asList("Bug", "Rock", "Dark"));

        //Poison
        strengths.put("poison", Arrays.asList("Grass", "Fairy"));
        weaknesses.put("poison", Arrays.asList("Psychic", "Ground"));
        immunities.put("poison", Arrays.asList());
        resistances.put("poison", Arrays.asList("Grass", "Fighting", "Poison", "Bug", "Fairy"));

        //Ground
        strengths.put("ground", Arrays.asList("Electric", "Fire", "Rock", "Steel"));
        weaknesses.put("ground", Arrays.asList("Water", "Grass"));
        immunities.put("ground", Arrays.asList("Electric"));
        resistances.put("ground", Arrays.asList("Poison", "Rock"));

        //Flying
        strengths.put("flying", Arrays.asList("Grass", "Bug", "Fighting"));
        weaknesses.put("flying", Arrays.asList("Electric", "Ice", "Rock"));
        immunities.put("flying", Arrays.asList("Ground"));
        resistances.put("flying", Arrays.asList("Grass", "Fighting", "Bug"));

        //Psychic
        strengths.put("psychic", Arrays.asList("Fighting", "Poison"));
        weaknesses.put("psychic", Arrays.asList("Bug", "Dark", "Ghost"));
        immunities.put("psychic", Arrays.asList());
        resistances.put("psychic", Arrays.asList("Fighting", "Psychic"));

        //Bug
        strengths.put("bug", Arrays.asList("Grass", "Psychic", "Dark"));
        weaknesses.put("bug", Arrays.asList("Fire", "Flying", "Rock"));
        immunities.put("bug", Arrays.asList());
        resistances.put("bug", Arrays.asList("Grass", "Fighting", "Ground"));

        //Rock
        strengths.put("rock", Arrays.asList("Fire", "Bug", "Ice", "Flying"));
        weaknesses.put("rock", Arrays.asList("Water", "Ground", "Grass", "Steel"));
        immunities.put("rock", Arrays.asList());
        resistances.put("rock", Arrays.asList("Normal", "Fire", "Poison", "Flying"));

        //Ghost
        strengths.put("ghost", Arrays.asList("Psychic", "Ghost"));
        weaknesses.put("ghost", Arrays.asList("Ghost", "Dark"));
        immunities.put("ghost", Arrays.asList("Normal", "Fighting"));
        resistances.put("ghost", Arrays.asList("Poison", "Bug"));

        //Dragon
        strengths.put("dragon", Arrays.asList("Dragon"));
        weaknesses.put("dragon", Arrays.asList("Ice", "Dragon", "Fairy"));
        immunities.put("dragon", Arrays.asList());
        resistances.put("dragon", Arrays.asList("Fire", "Water", "Electric", "Grass"));

        //Dark
        strengths.put("dark", Arrays.asList("Psychic", "Ghost"));
        weaknesses.put("dark", Arrays.asList("Fighting", "Fairy", "Bug"));
        immunities.put("dark", Arrays.asList("Psychic"));
        resistances.put("dark", Arrays.asList("Ghost", "Dark"));

        //Steel
        strengths.put("steel", Arrays.asList("Ice", "Rock", "Fairy"));
        weaknesses.put("steel", Arrays.asList("Fire", "Ground", "Fighting"));
        immunities.put("steel", Arrays.asList("Poison"));
        resistances.put("steel", Arrays.asList("Normal", "Grass", "Ice", "Flying", "Psychic", "Bug", "Rock", "Dragon", "Steel", "Fairy"));

        //Fairy
        strengths.put("fairy", Arrays.asList("Dark", "Dragon"));
        weaknesses.put("fairy", Arrays.asList("Steel", "Poison"));
        immunities.put("fairy", Arrays.asList("Dragon"));
        resistances.put("fairy", Arrays.asList("Fighting", "Bug", "Dark"));
    }

    public static List<String> getStrengths(String type) {
        return strengths.getOrDefault(type, new ArrayList<>());
    }

    public static List<String> getWeaknesses(String type) {
        return weaknesses.getOrDefault(type, new ArrayList<>());
    }

    public static List<String> getImmunities(String type) {
        return immunities.getOrDefault(type, new ArrayList<>());
    }

    public static List<String> getResistances(String type) {
        return resistances.getOrDefault(type, new ArrayList<>());
    }
}
