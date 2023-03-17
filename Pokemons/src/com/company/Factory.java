package com.company;

class Factory {
    public Pokemon creeazaPokemon(String tip) throws ClassNotFoundException {
        switch (tip) {
            case "Neutrel1":
                return new Neutrel1();
            case "Neutrel2":
                return new Neutrel2();
            case "Pikachu":
                return new Pikachu();
            case "Bulbasaur":
                return new Bulbasaur();
            case "Charmander":
                return new Charmander();
            case "Squirtle":
                return new Squirtle();
            case "Snorlax":
                return new Snorlax();
            case "Vulpix":
                return new Vulpix();
            case "Eevee":
                return new Eevee();
            case "Jigglypuff":
                return new Jigglypuff();
            case "Meowth":
                return new Meowth();
            case "Psyduck":
                return new Psyduck();
        }
        throw new IllegalArgumentException("Tipul de pokemon " + tip + " nu este cunoscut.");
    }
}
