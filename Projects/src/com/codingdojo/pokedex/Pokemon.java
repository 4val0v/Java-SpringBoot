package com.codingdojo.pokedex;

public class Pokemon {

    private String name;
    private String type;
    private int health;
    private static int counter;

    public Pokemon() {
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static void main(String[] args) {

        Pokedex pokedex = new Pokedex();

        Pokemon p1 = pokedex.createPokemon("Pikachu", "cat", 100);
        Pokemon p2 = pokedex.createPokemon("Not Pikachu", "not cat", 100);

        pokedex.attackPokemon(p2); // this assignment wasn't written correctly!!!!

        System.out.println(Pokemon.counter);

        pokedex.pokemonInfo(p1);

    }

}

