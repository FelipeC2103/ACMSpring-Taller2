package org.example.taller2acmjavaspring.dto;

import java.util.List;

public class PokemonDto {

    private String name;
    private int weight;
    private List<String> abilities;


    public PokemonDto(String name, int weight, List<String> abilities) {
        this.name = name;
        this.weight = weight;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }
}