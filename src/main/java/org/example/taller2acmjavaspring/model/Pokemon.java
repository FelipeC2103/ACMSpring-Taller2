package org.example.taller2acmjavaspring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Serializable{

    private String name;
    private int id;
    private int weight;
    private int height;
    private List<Ability> abilities = new ArrayList<>();



    public Pokemon(String name, int id, int weight, int height, List<Ability> abilities) {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }


    public static class Ability {

        private AbilityInfo ability;

        public AbilityInfo getAbility() {
            return ability;
        }
        public void setAbility(AbilityInfo ability) {
            this.ability = ability;
        }
    }


    public static class AbilityInfo {
        private String name;
        private String url;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
    }

}
