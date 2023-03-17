package com.company;

public class Singleton {

    private static Singleton instance = null;
    public Pokemon final_winner;
    Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
