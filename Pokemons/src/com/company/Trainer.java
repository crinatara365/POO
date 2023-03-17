package com.company;

public class Trainer {
    String Name;
    int Age;
    Pokemon[] list_of_pokemons;

    public Trainer(String Name, int Age, Pokemon[] list_of_pokemons) {
        this.Name = Name;
        this.Age = Age;
        this.list_of_pokemons = list_of_pokemons;
    }
}
