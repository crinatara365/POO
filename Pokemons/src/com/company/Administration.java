package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Administration extends Main{

    /* Metoda pentru batalia dintre un pokemon si Neutrel1, intorcandu-se castigatorul */
    public static Pokemon Battle_vsNeutrel1(Pokemon pokemon, Pokemon Neutrel1, File file) throws IOException {

        /* Folosim design pattern-ul Command pentru a crea comenzile date de antrenori pokemonilor sai */
        Ordinay_Attack command1 = new Ordinay_Attack();
        Ability1 command2 = new Ability1();
        Ability2 command3 = new Ability2();
        Command[] list_of_commands = new Command[3];
        list_of_commands[0] = command1;
        list_of_commands[1] = command2;
        list_of_commands[2] = command3;
        Random rand1 = new Random();
        int hp1 = Neutrel1.getHP(), hp2 = pokemon.getHP();
        int cooldown1 = 0, cooldown2 = 0;
        String stun = null, dodge = null, stun_aux = null, dodge_aux = null;

        /* atata timp cat ambii pokemoni mai au viata (HP != 0) */
        while (Neutrel1.getHP() > 0 && pokemon.HP > 0) {
            /* antrenorii dau comenzi aleator pokemonilor sai */
            int selected_command = rand1.nextInt(3);

            /* antrenorul a ales comanda de Ordinay_Attack */
            if (list_of_commands[selected_command] == command1) {
                logger.Print(pokemon.Name+" atacks with Ordinary Attack", 0, file);
                /* verificam ce fel de atac detine pokemonul */
                if (pokemon.Normal_Attack != 0)
                    Neutrel1.setHP(Neutrel1.getHP() - pokemon.getNormal_Attack() + Neutrel1.getDef());
                else
                    Neutrel1.setHP(Neutrel1.getHP() - pokemon.getSpecial_Attack() + Neutrel1.getSpecial_Def());
            }

            /* antrenorul a ales comanda de Ability1 */
            if (list_of_commands[selected_command] == command2) {
                /* inainte de a se folosi, se verifica daca este in cooldown */
                if (cooldown1 == 0) {
                    /* scadem damage-ul din hp-ul lui Neutrel */
                    logger.Print(pokemon.Name+" atacks with Ability1", 0, file);
                    int damage = Integer.parseInt(command2.execut_command(pokemon)[0]);
                    Neutrel1.setHP(Neutrel1.getHP() - damage);
                    /* se pastreaza cooldown-ul pentru a sti cate momente de timp nu mai poate fi folosita abilitatea */
                    cooldown1 = Integer.parseInt(command2.execut_command(pokemon)[3]) + 1;
                    /* se pastreaza stun-ul pentru a sti daca Neutrel poate sa atace tura viitoare */
                    stun_aux = command2.execut_command(pokemon)[1];
                    /* se pastreaza dodge pentru a sti daca se modifica hp-ul pokemonului la atacul lui Neutrel */
                    dodge_aux = command2.execut_command(pokemon)[2];
                }
                else
                    continue;
            }

            /* antrenorul a ales comanda de Ability2 */
            if (list_of_commands[selected_command] == command3) {
                /* inainte de a se folosi, se verifica daca este in cooldown */
                if (cooldown2 == 0) {
                    logger.Print(pokemon.Name+" atacks with Ability2", 0, file);
                    /* scadem damage-ul din hp-ul lui Neutrel */
                    int damage = Integer.parseInt(command3.execut_command(pokemon)[0]);
                    Neutrel1.setHP(Neutrel1.HP - damage);
                    /* se pastreaza cooldown-ul pentru a sti cate momente de timp nu mai poate fi folosita abilitatea */
                    cooldown2 = Integer.parseInt(command3.execut_command(pokemon)[3]) + 1;
                    /* se pastreaza stun-ul pentru a sti daca Neutrel poate sa atace tura viitoare */
                    stun_aux = command3.execut_command(pokemon)[1];
                    dodge_aux = command3.execut_command(pokemon)[2];
                }
                else
                    continue;
            }

            /* verificam daca Neutrel poate sa atace */
            if (Objects.equals(stun, "No") || stun == null) {
                /* verificam daca pokemonul se fereste */
                if (!Objects.equals(dodge, "Yes")) {
                    logger.Print("Neutrel1 atacks with Ordinary Attack", 0, file);
                    pokemon.setHP(pokemon.getHP() - Neutrel1.getNormal_Attack() + pokemon.getDef());
                }
                else {
                    dodge = null;
                }
            }
            else {
                stun = null;
                dodge = null;
            }
            if(stun_aux != null) stun = stun_aux;
            if(dodge_aux != null) dodge = dodge_aux;
            stun_aux = null;
            dodge_aux = null;
            if (cooldown1 != 0) cooldown1 = cooldown1 - 1;
            if (cooldown2 != 0) cooldown2 = cooldown2 - 1;
            logger.Print("Results:\t"+pokemon.Name+": HP "+pokemon.HP+","+"Ability1 cooldown: "+cooldown1+","+
                    "Ability2 cooldown: "+cooldown2+"\t Neutrel: HP "+Neutrel1.HP,0,file);
        }
        if(Neutrel1.getHP() <= 0) {
            /* pokemonul este castigator -> +1 la toate campurile */
            pokemon.setHP(hp2 + 1);
            if(pokemon.Normal_Attack != 0)
                pokemon.setNormal_Attack(pokemon.getNormal_Attack() + 1);
            else
                pokemon.setSpecial_Attack(pokemon.getSpecial_Attack() + 1);
            pokemon.setDef(pokemon.getDef() + 1);
            pokemon.setSpecial_Def(pokemon.getSpecial_Def() + 1);
            /* se reseteaza HP-ul lui Neutrel1 pentru bataliile viitoare */
            Neutrel1.setHP(hp1);
            return pokemon;
        }
        else {
            /* Neutrel este castigator (n-o sa se intample niciodata) -> +1 la toate categoriile */
            Neutrel1.setHP(hp1 + 1);
            Neutrel1.setNormal_Attack(Neutrel1.getNormal_Attack() + 1);
            Neutrel1.setDef(Neutrel1.getDef() + 1);
            Neutrel1.setSpecial_Def(Neutrel1.getSpecial_Def() + 1);
            pokemon.setHP(hp2);
            return Neutrel1;
        }
    }

    /* Metoda pentru batalia dintre un pokemon si Neutrel2, intorcandu-se castigatorul */
    public static Pokemon Battle_vsNeutrel2(Pokemon pokemon, Pokemon Neutrel2, File file) throws IOException {
        /* Folosim design pattern-ul Command pentru a crea comenzile date de antrenori pokemonilor sai */
        Ordinay_Attack command1 = new Ordinay_Attack();
        Ability1 command2 = new Ability1();
        Ability2 command3 = new Ability2();
        Command[] list_of_commands = new Command[3];
        list_of_commands[0] = command1;
        list_of_commands[1] = command2;
        list_of_commands[2] = command3;
        Random rand1 = new Random();
        int hp1 = Neutrel2.getHP();
        int hp2 = pokemon.getHP();
        int cooldown1 = 0, cooldown2 = 0;
        String stun = null, dodge = null;

        /* atata timp cat ambii pokemoni mai au viata (HP != 0) */
        while (Neutrel2.getHP() > 0 && pokemon.HP > 0) {
            /* antrenorii dau comenzi aleator pokemonilor sai */
            int selected_command = rand1.nextInt(3);

            /* antrenorul a ales comanda de Ordinay_Attack */
            if (list_of_commands[selected_command] == command1) {
                logger.Print(pokemon.Name+" atacks with Ordinary Attack", 0, file);
                /* verificam ce fel de atac detine pokemonul */
                if (pokemon.Normal_Attack != 0)
                    Neutrel2.setHP(Neutrel2.getHP() - pokemon.getNormal_Attack() + Neutrel2.getDef());
                else
                    Neutrel2.setHP(Neutrel2.getHP() - pokemon.getSpecial_Attack() + Neutrel2.getSpecial_Def());
            }

            /* antrenorul a ales comanda de Ability1 */
            if (list_of_commands[selected_command] == command2) {
                /* inainte de a se folosi, se verifica daca este in cooldown */
                if (cooldown1 == 0) {
                    logger.Print(pokemon.Name + " atacks with Ability1", 0, file);
                    /* scadem damage-ul din hp-ul lui Neutrel */
                    int damage = Integer.parseInt(command2.execut_command(pokemon)[0]);
                    Neutrel2.setHP(Neutrel2.getHP() - damage);
                    /* se pastreaza cooldown-ul pentru a sti cate momente de timp nu mai poate fi folosita abilitatea */
                    cooldown1 = Integer.parseInt(command2.execut_command(pokemon)[3]) + 1;
                    /* se pastreaza stun-ul pentru a sti daca Neutrel poate sa atace tura viitoare */
                    stun = command2.execut_command(pokemon)[1];
                    dodge = command2.execut_command(pokemon)[2];
                } else
                    continue;
            }

            /* antrenorul a ales comanda de Ability2 */
            if (list_of_commands[selected_command] == command3) {
                /* inainte de a se folosi, se verifica daca este in cooldown */
                if (cooldown2 == 0) {
                    logger.Print(pokemon.Name+" atacks with Ability2", 0, file);
                    /* scadem damage-ul din hp-ul lui Neutrel */
                    int damage = Integer.parseInt(command3.execut_command(pokemon)[0]);
                    Neutrel2.setHP(Neutrel2.HP - damage);
                    /* se pastreaza cooldown-ul pentru a sti cate momente de timp nu mai poate fi folosita abilitatea */
                    cooldown2 = Integer.parseInt(command3.execut_command(pokemon)[3]) + 1;
                    /* se pastreaza stun-ul pentru a sti daca Neutrel poate sa atace tura viitoare */
                    stun = command3.execut_command(pokemon)[1];
                    dodge = command3.execut_command(pokemon)[2];
                }
                else
                    continue;
            }

            /* verificam daca Neutrel poate sa atace */
            if (Objects.equals(stun, "No") || stun == null) {
                /* verificam daca pokemonul se fereste */
                if (Objects.equals(dodge, "No") || dodge == null) {
                    logger.Print("Neutrel2 atacks with Ordinary Attack", 0, file);
                    pokemon.setHP(pokemon.getHP() - Neutrel2.getNormal_Attack() + pokemon.getDef());
                }
                else
                    dodge = null;
            }
            else {
                stun = null;
                dodge = null;
            }
            if (cooldown1 != 0) cooldown1 = cooldown1 - 1;
            if (cooldown2 != 0) cooldown2 = cooldown2 - 1;
            logger.Print("Results:\t"+pokemon.Name+": HP "+pokemon.HP+","+"Ability1 cooldown: "+cooldown1+","+
                    "Ability2 cooldown: "+cooldown2+"\t Neutrel: HP "+Neutrel2.HP,0,file);
        }
        if (Neutrel2.getHP() <= 0) {
            /* pokemonul este castigator -> +1 la toate campurile */
            pokemon.setHP(hp2 + 1);
            if(pokemon.Normal_Attack != 0)
                pokemon.setNormal_Attack(pokemon.getNormal_Attack() + 1);
            else
                pokemon.setSpecial_Attack(pokemon.getSpecial_Attack() + 1);
            pokemon.setDef(pokemon.getDef() + 1);
            pokemon.setSpecial_Def(pokemon.getSpecial_Def() + 1);
            /* se reseteaza HP-ul lui Neutrel1 pentru bataliile viitoare */
            Neutrel2.setHP(hp1);
            return pokemon;
        }
        else {
            /* Neutrel este castigator -> +1 la toate categoriile */
            Neutrel2.setHP(hp1 + 1);
            Neutrel2.setNormal_Attack(Neutrel2.getNormal_Attack() + 1);
            Neutrel2.setDef(Neutrel2.getDef() + 1);
            Neutrel2.setSpecial_Def(Neutrel2.getSpecial_Def() + 1);
            pokemon.setHP(hp2);
            return Neutrel2;
        }
    }

    /* Metoda pentru calcularea sumei tuturor proprietatilor unui pokemon */
    public static int Properties(Pokemon pokemon) {
        /* nu ne intereseaza ce fel de atac detine pentru ca oricum e 0 daca nu-l detine, deci nu influenteaza suma */
        int sum_of_all = pokemon.HP + pokemon.Normal_Attack + pokemon.Special_Attack + pokemon.Def + pokemon.Special_Def;
        return sum_of_all;
    }

    /* Metoda care intoarce indicele celui mai bun pokemon */
    public static int Maximum(int[] v) {
        int max = -1, indice = -1;
        for(int i = 0; i < v.length; i++)
            if(v[i] > max) {
                max = v[i];
                indice = i;
            }
        return indice;
    }
}
