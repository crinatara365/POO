package com.company;

import java.util.Objects;
import java.util.Random;

abstract class Pokemon {
    String Name;
    int HP;
    int Normal_Attack;
    int Special_Attack;
    int Def;
    int Special_Def;
    String[] Ability1;
    String[] Ability2;

    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setHP(int HP);
    public abstract int getHP();
    public abstract void setNormal_Attack(int normal_Attack);
    public abstract int getNormal_Attack();
    public abstract void setSpecial_Attack(int special_Attack);
    public abstract int getSpecial_Attack();
    public abstract void setDef(int def);
    public abstract int getDef();
    public abstract void setSpecial_Def(int special_Def);
    public abstract int getSpecial_Def();
    public abstract void setAbility1(String[] ability1);
    public abstract String[] getAbility1();
    public abstract void setAbility2(String[] ability2);
    public abstract String[] getAbility2();

}

class Neutrel1 extends Pokemon {

    public Neutrel1() {
        this.setName("Neutrel1");
        this.setHP(10);
        this.setNormal_Attack(3);
        this.setSpecial_Attack(0);
        this.setDef(1);
        this.setSpecial_Def(1);
        this.setAbility1(null);
        this.setAbility2(null);
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Neutrel2 extends Pokemon {

    public Neutrel2() {
        this.setName("Neutrel2");
        this.setHP(20);
        this.setNormal_Attack(4);
        this.setSpecial_Attack(0);
        this.setDef(1);
        this.setSpecial_Def(1);
        this.setAbility1(null);
        this.setAbility2(null);
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Pikachu extends Pokemon {

    public Pikachu() {
        this.setName("Pikachu");
        this.setHP(35);
        this.setNormal_Attack(0);
        this.setSpecial_Attack(4);
        this.setDef(2);
        this.setSpecial_Def(3);
        this.setAbility1(new String[]{"6", "No", "No", "4"});
        this.setAbility2(new String[]{"4", "Yes", "Yes", "5"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        this.setName("Bulbasaur");
        this.setHP(42);
        this.setNormal_Attack(0);
        this.setSpecial_Attack(5);
        this.setDef(3);
        this.setSpecial_Def(1);
        this.setAbility1(new String[]{"6", "No", "No", "4"});
        this.setAbility2(new String[]{"5", "No", "No", "3"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Charmander extends Pokemon {
    public Charmander() {
        this.setName("Charmander");
        this.setHP(50);
        this.setNormal_Attack(4);
        this.setSpecial_Attack(0);
        this.setDef(3);
        this.setSpecial_Def(2);
        this.setAbility1(new String[]{"4", "Yes", "No", "4"});
        this.setAbility2(new String[]{"7", "No", "No", "6"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Squirtle extends Pokemon {
    public Squirtle() {
        this.setName("Squirtle");
        this.setHP(60);
        this.setNormal_Attack(0);
        this.setSpecial_Attack(3);
        this.setDef(5);
        this.setSpecial_Def(5);
        this.setAbility1(new String[]{"4", "No", "No", "3"});
        this.setAbility2(new String[]{"2", "Yes", "No", "2"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Snorlax extends Pokemon {
    public Snorlax() {
        this.setName("Snorlax");
        this.setHP(62);
        this.setNormal_Attack(3);
        this.setSpecial_Attack(0);
        this.setDef(6);
        this.setSpecial_Def(4);
        this.setAbility1(new String[]{"4", "Yes", "No", "5"});
        this.setAbility2(new String[]{"0", "No", "Yes", "5"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Vulpix extends Pokemon {
    public Vulpix() {
        this.setName("Vulpix");
        this.setHP(36);
        this.setNormal_Attack(5);
        this.setSpecial_Attack(0);
        this.setDef(2);
        this.setSpecial_Def(4);
        this.setAbility1(new String[]{"8", "Yes", "No", "6"});
        this.setAbility2(new String[]{"2", "No", "Yes", "7"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Eevee extends Pokemon {
    public Eevee() {
        this.setName("Eevee");
        this.setHP(39);
        this.setNormal_Attack(0);
        this.setSpecial_Attack(4);
        this.setDef(3);
        this.setSpecial_Def(3);
        this.setAbility1(new String[]{"5", "No", "No", "3"});
        this.setAbility2(new String[]{"3", "Yes", "No", "3"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Jigglypuff extends Pokemon {
    public Jigglypuff() {
        this.setName("Jigglypuff");
        this.setHP(34);
        this.setNormal_Attack(4);
        this.setSpecial_Attack(0);
        this.setDef(2);
        this.setSpecial_Def(3);
        this.setAbility1(new String[]{"4", "Yes", "No", "4"});
        this.setAbility2(new String[]{"3", "Yes", "No", "4"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Meowth extends Pokemon {
    public Meowth() {
        this.setName("Meowth");
        this.setHP(41);
        this.setNormal_Attack(3);
        this.setSpecial_Attack(0);
        this.setDef(4);
        this.setSpecial_Def(2);
        this.setAbility1(new String[]{"5", "No", "Yes", "4"});
        this.setAbility2(new String[]{"1", "No", "Yes", "3"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}

class Psyduck extends Pokemon {
    public Psyduck() {
        this.setName("Psyduck");
        this.setHP(43);
        this.setNormal_Attack(3);
        this.setSpecial_Attack(0);
        this.setDef(3);
        this.setSpecial_Def(3);
        this.setAbility1(new String[]{"2", "No", "No", "4"});
        this.setAbility2(new String[]{"2", "Yes", "No", "5"});
    }

    public void setName(String name) {this.Name = name;}
    public void setHP(int hp){this.HP = hp;}
    public void setNormal_Attack(int normal_attack){this.Normal_Attack = normal_attack;}
    public void setSpecial_Attack(int special_attack){this.Special_Attack = special_attack;}
    public void setDef(int def){this.Def = def;}
    public void setSpecial_Def(int special_Def){this.Special_Def = special_Def;}
    public void setAbility1(String[] ability1){this.Ability1 = ability1;}
    public void setAbility2(String[] ability2){this.Ability2 = ability2;}


    public String getName() {return Name;}
    public int getHP() {return HP;}
    public int getNormal_Attack() {return Normal_Attack;}
    public int getSpecial_Attack() {return Special_Attack;}
    public int getDef() {return Def;}
    public int getSpecial_Def() {return Special_Def;}
    public String[] getAbility1() {return Ability1;};
    public String[] getAbility2() {return Ability2;};
}
