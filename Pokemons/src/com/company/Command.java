package com.company;

public abstract class Command {
    public abstract String[] execut_command(Pokemon pokemon);
}

class Ordinay_Attack extends Command {
    public String[] execut_command(Pokemon pokemon) {
        return null;
    }
}

class Ability1 extends Command {
    public String[] execut_command(Pokemon pokemon) {
        String[] str = pokemon.getAbility1();
        return str;
    }
}

class Ability2 extends Command {
    public String[] execut_command(Pokemon pokemon) {
        String[] str = pokemon.getAbility2();
        return str;
    }
}
