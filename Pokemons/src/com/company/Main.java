package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    static Trainer[] trainers = new Trainer[2];
    static Pokemon[] winners_pokemon1 = new Pokemon[3];
    static Pokemon[] winners_pokemon2 = new Pokemon[3];
    static Logger logger = new Logger();
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        File folder = new File("input");
        File[] listOfFiles = folder.listFiles();
        int numFiles = 0, contor = 0;

        /* Folosim design pattern-ul Factory pentru a crea pokemonii */
        Factory f = new Factory();
        Pokemon Neutrel1 = f.creeazaPokemon("Neutrel1");
        Pokemon Neutrel2 = f.creeazaPokemon("Neutrel2");

        for (File file : listOfFiles) {
            /* Atata timp cat sunt fisiere de test (sunt mereu 10 dar am luat cazul general) */
            if (file.isFile()) {
                numFiles ++;
                int number_of_test = numFiles;
                /* scriem mereu listOfFiles[0] ca si fisier de output pentru ca oricum nu este folosit niciodata, deci nu conteaza */
                logger.Print("TEST " + number_of_test,0, listOfFiles[0]);
                BufferedReader br= new BufferedReader(new FileReader(file));
                String line;

                /* Atata timp cat sunt linii in fisiere (sunt mereu 2 dar am luat cazul general) */
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(",");
                    int age = Integer.parseInt(str[1]);

                    /* Citim cei 3 pokemoni din fisierul de input si ii adaugam in lista de pokemoni */
                    Pokemon pokemon1 = f.creeazaPokemon(str[2]);
                    Pokemon pokemon2 = f.creeazaPokemon(str[3]);
                    Pokemon pokemon3 = f.creeazaPokemon(str[4]);
                    Pokemon[] pokemons = new Pokemon[3];
                    pokemons[0] = pokemon1;
                    pokemons[1] = pokemon2;
                    pokemons[2] = pokemon3;

                    /* Citim obiectele atribuite fiecarui pokemon in parte */
                    for(int i = 5; i <= 13; i++) {

                        /* Scut: +2 la Defense si Special Defense */
                        if(Objects.equals(str[i], "Scut"))
                            /* este obiect al primului pokemon */
                            if(i < 8) {
                                int defense = pokemons[0].getDef();
                                int special_defense = pokemons[0].getSpecial_Def();
                                pokemons[0].setDef(defense + 2);
                                pokemons[0].setSpecial_Def(special_defense + 2);
                            }
                            /* este obiect al ultimul pokemon */
                            else if(i > 10) {
                                int defense = pokemons[2].getDef();
                                int special_defense = pokemons[2].getSpecial_Def();
                                pokemons[2].setDef(defense + 2);
                                pokemons[2].setSpecial_Def(special_defense + 2);
                            }
                            /* este obiect al celui de-al doilea pokemon */
                            else {
                                int defense = pokemons[1].getDef();
                                int special_defense = pokemons[1].getSpecial_Def();
                                pokemons[1].setDef(defense + 2);
                                pokemons[1].setSpecial_Def(special_defense + 2);
                            }

                        /* Vestă: +10 la HP */
                        if(Objects.equals(str[i], "Vestă"))
                            if(i < 8) {
                                int hp = pokemons[0].getHP();
                                pokemons[0].setHP(hp + 10);
                            }
                            else if(i > 10) {
                                int hp = pokemons[2].getHP();
                                pokemons[2].setHP(hp + 10);
                            }
                            else {
                                int hp = pokemons[1].getHP();
                                pokemons[1].setHP(hp + 10);
                            }

                        /* Săbiuță: +3 la Normal_Attack (daca pokemonul il detine) */
                        if(Objects.equals(str[i], "Săbiuță"))
                            if(i < 8) {
                                int normal_attack = pokemons[0].getNormal_Attack();
                                if(normal_attack != 0)
                                    pokemons[0].setNormal_Attack(normal_attack + 3);
                            }
                            else if(i > 10) {
                                int normal_attack = pokemons[2].getNormal_Attack();
                                if(normal_attack != 0)
                                    pokemons[2].setNormal_Attack(normal_attack + 3);
                            }
                            else {
                                int normal_attack = pokemons[1].getNormal_Attack();
                                if(normal_attack != 0)
                                    pokemons[1].setNormal_Attack(normal_attack + 3);
                            }

                        /* Baghetă Magică: +3 la Special_Attack (daca pokemonul il detine) */
                        if(Objects.equals(str[i], "Baghetă Magică"))
                            if(i < 8) {
                                int special_attack = pokemons[0].getSpecial_Attack();
                                if(special_attack != 0)
                                    pokemons[0].setSpecial_Attack(special_attack + 3);
                            }
                            else if(i > 10) {
                                int special_attack = pokemons[2].getSpecial_Attack();
                                if(special_attack != 0)
                                    pokemons[2].setSpecial_Attack(special_attack + 3);
                            }
                            else {
                                int special_attack = pokemons[1].getSpecial_Attack();
                                if(special_attack != 0)
                                    pokemons[1].setSpecial_Attack(special_attack + 3);
                            }

                        /* Vitamine: +2 la HP si Normal_Attack/Special_Attack */
                        if(Objects.equals(str[i], "Vitamine"))
                            if(i < 8) {
                                int hp = pokemons[0].getHP();
                                int normal_attack = pokemons[0].getNormal_Attack();
                                int special_attack = pokemons[0].getSpecial_Attack();
                                pokemons[0].setHP(hp + 2);
                                if(normal_attack != 0)
                                    pokemons[0].setNormal_Attack(normal_attack + 2);
                                else
                                    pokemons[0].setSpecial_Attack(special_attack + 2);
                            }
                            else if(i > 10) {
                                int hp = pokemons[2].getHP();
                                int normal_attack = pokemons[2].getNormal_Attack();
                                int special_attack = pokemons[2].getSpecial_Attack();
                                pokemons[2].setHP(hp + 2);
                                if(normal_attack != 0)
                                    pokemons[2].setNormal_Attack(normal_attack + 2);
                                else
                                    pokemons[2].setSpecial_Attack(special_attack + 2);
                            }
                            else {
                                int hp = pokemons[1].getHP();
                                int normal_attack = pokemons[1].getNormal_Attack();
                                int special_attack = pokemons[1].getSpecial_Attack();
                                pokemons[1].setHP(hp + 2);
                                if(normal_attack != 0)
                                    pokemons[1].setNormal_Attack(normal_attack + 2);
                                else
                                    pokemons[1].setSpecial_Attack(special_attack + 2);
                            }

                        /* Brad de Crăciun: +3 la Normal_Attack (daca pokemonul il detine) si +1 la Defense */
                        if(Objects.equals(str[i], "Brad de Crăciun"))
                            if(i < 8) {
                                int defense = pokemons[0].getDef();
                                int normal_attack = pokemons[0].getNormal_Attack();
                                pokemons[0].setDef(defense + 1);
                                if(normal_attack != 0)
                                    pokemons[0].setNormal_Attack(normal_attack + 3);
                            }
                            else if(i > 10) {
                                int defense = pokemons[2].getDef();
                                int normal_attack = pokemons[2].getNormal_Attack();
                                pokemons[2].setDef(defense + 1);
                                if(normal_attack != 0)
                                    pokemons[2].setNormal_Attack(normal_attack + 3);
                            }
                            else {
                                int defense = pokemons[1].getDef();
                                int normal_attack = pokemons[1].getNormal_Attack();
                                pokemons[1].setDef(defense + 1);
                                if(normal_attack != 0)
                                    pokemons[1].setNormal_Attack(normal_attack + 3);
                            }

                        /* Pelerină: +3 la Special_Defense */
                        if(Objects.equals(str[i], "Pelerină"))
                            if(i < 8) {
                                int special_defense = pokemons[0].getSpecial_Def();
                                pokemons[0].setSpecial_Def(special_defense + 3);
                            }
                            else if(i > 10) {
                                int special_defense = pokemons[2].getSpecial_Def();
                                pokemons[2].setSpecial_Def(special_defense + 3);
                            }
                            else {
                                int special_defense = pokemons[1].getSpecial_Def();
                                pokemons[1].setSpecial_Def(special_defense + 3);
                            }
                    }

                    /* Cream antrenorul cu datele din fisierul de input */
                    Trainer trainer = new Trainer(str[0], age, pokemons);
                    trainers[contor] = trainer;
                    contor++;
                }

                /* In momentul asta avem in arena cei 2 antrenori fiecare cu cei 3 pokemoni ai sai */
                logger.Print("First trainer enters battlefield with:", 0, listOfFiles[0]);
                logger.Print("\t"+trainers[0].list_of_pokemons[0].Name+": "+trainers[0].list_of_pokemons[0].HP+" "
                        +trainers[0].list_of_pokemons[0].Normal_Attack+" "+trainers[0].list_of_pokemons[0].Special_Attack+" "
                        +trainers[0].list_of_pokemons[0].Def+" "+trainers[0].list_of_pokemons[0].Special_Def, 0, listOfFiles[0]);
                logger.Print("\t"+trainers[0].list_of_pokemons[1].Name+": "+trainers[0].list_of_pokemons[1].HP+" "
                        +trainers[0].list_of_pokemons[1].Normal_Attack+" "+trainers[0].list_of_pokemons[1].Special_Attack+" "
                        +trainers[0].list_of_pokemons[1].Def+" "+trainers[0].list_of_pokemons[1].Special_Def, 0, listOfFiles[0]);
                logger.Print("\t"+trainers[0].list_of_pokemons[2].Name+": "+trainers[0].list_of_pokemons[2].HP+" "
                        +trainers[0].list_of_pokemons[2].Normal_Attack+" "+trainers[0].list_of_pokemons[2].Special_Attack+" "
                        +trainers[0].list_of_pokemons[2].Def+" "+trainers[0].list_of_pokemons[2].Special_Def, 0, listOfFiles[0]);

                logger.Print("Second trainer enters battlefield with:", 0, listOfFiles[0]);
                logger.Print("\t"+trainers[1].list_of_pokemons[0].Name+": "+trainers[1].list_of_pokemons[0].HP+" "
                        +trainers[1].list_of_pokemons[0].Normal_Attack+" "+trainers[1].list_of_pokemons[0].Special_Attack+" "
                        +trainers[1].list_of_pokemons[0].Def+" "+trainers[1].list_of_pokemons[0].Special_Def, 0, listOfFiles[0]);
                logger.Print("\t"+trainers[1].list_of_pokemons[1].Name+": "+trainers[1].list_of_pokemons[1].HP+" "
                        +trainers[1].list_of_pokemons[1].Normal_Attack+" "+trainers[1].list_of_pokemons[1].Special_Attack+" "
                        +trainers[1].list_of_pokemons[1].Def+" "+trainers[1].list_of_pokemons[1].Special_Def, 0, listOfFiles[0]);
                logger.Print("\t"+trainers[1].list_of_pokemons[2].Name+": "+trainers[1].list_of_pokemons[2].HP+" "
                        +trainers[1].list_of_pokemons[2].Normal_Attack+" "+trainers[1].list_of_pokemons[2].Special_Attack+" "
                        +trainers[1].list_of_pokemons[2].Def+" "+trainers[1].list_of_pokemons[2].Special_Def, 0, listOfFiles[0]);

                /* se creeaza cele 3 evenimente posibile */
                String[] events = new String[]{"vsNeutrel1", "vsNeutrel2", "vsOtherPokemon"};
                int contor1 = 0, contor2 = 1, contor3 = 1;
                Random rand = new Random();

                /* Completam campurile winners_pokemon1 si winners_pokemon pentru cazul in care arena alege din prima batalia finala */
                winners_pokemon1[0] = trainers[0].list_of_pokemons[0];
                winners_pokemon1[1] = trainers[0].list_of_pokemons[1];
                winners_pokemon1[2] = trainers[0].list_of_pokemons[2];
                winners_pokemon2[0] = trainers[1].list_of_pokemons[0];
                winners_pokemon2[1] = trainers[1].list_of_pokemons[1];
                winners_pokemon2[2] = trainers[1].list_of_pokemons[2];

                for(int i = 0; i < 3; i++) {
                    logger.Print("ROUND " + contor2, 0, listOfFiles[0]);

                    /* Arena alege aleator evenimente pana se alege evenimentul vsOtherPokemon */
                    while (contor1 == 0) {
                        int selected_event = rand.nextInt(3);
                        /* tinem evidenta numarului de evenimente cu ajutorul design pattern-ului Observator care este notificat
                        de fiecare data cand se actualizeaza numarul de evenimente */
                        Subiect subiect = new Subiect();
                        Observator observator = new Observator(subiect);
                        subiect.setCurrent_number_of_events(contor3);
                        contor3++;

                        /* Arena a ales evenimentul vsNeutrel1 */
                        if (events[selected_event].equals("vsNeutrel1")) {
                            logger.Print("Battle "+trainers[0].list_of_pokemons[i].Name+" vs Neutrel1", 0, listOfFiles[0]);
                            winners_pokemon1[i] = Administration.Battle_vsNeutrel1(trainers[0].list_of_pokemons[i], Neutrel1, listOfFiles[0]);
                            logger.Print("Battle "+trainers[1].list_of_pokemons[i].Name+" vs Neutrel1", 0, listOfFiles[0]);
                            winners_pokemon2[i] = Administration.Battle_vsNeutrel1(trainers[1].list_of_pokemons[i], Neutrel1, listOfFiles[0]);
                            logger.Print("Winners: ", 0 ,listOfFiles[0]);
                            logger.Print("\t"+winners_pokemon1[i].Name+": "+winners_pokemon1[i].HP+" "+winners_pokemon1[i].Normal_Attack
                                    +" "+winners_pokemon1[i].Special_Attack+" "+winners_pokemon1[i].Def+" "+winners_pokemon1[i].Special_Def,0,listOfFiles[0]);
                            logger.Print("\t"+winners_pokemon2[i].Name+": "+winners_pokemon2[i].HP+" "+winners_pokemon2[i].Normal_Attack
                                    +" "+winners_pokemon2[i].Special_Attack+" "+winners_pokemon2[i].Def+" "+winners_pokemon2[i].Special_Def,0,listOfFiles[0]);
                        }

                        /* Arena a ales evenimentul vsNeutrel2 */
                        if (events[selected_event].equals("vsNeutrel2")) {
                            logger.Print("Battle "+trainers[0].list_of_pokemons[i].Name+" vs Neutrel2", 0, listOfFiles[0]);
                            winners_pokemon1[i] = Administration.Battle_vsNeutrel2(trainers[0].list_of_pokemons[i], Neutrel2, listOfFiles[0]);
                            logger.Print("Battle "+trainers[1].list_of_pokemons[i].Name+" vs Neutrel2", 0, listOfFiles[0]);
                            winners_pokemon2[i] = Administration.Battle_vsNeutrel2(trainers[1].list_of_pokemons[i], Neutrel2, listOfFiles[0]);
                            logger.Print("Winners: ", 0 ,listOfFiles[0]);
                            logger.Print("\t"+winners_pokemon1[i].Name+": "+winners_pokemon1[i].HP+" "+winners_pokemon1[i].Normal_Attack
                                    +" "+winners_pokemon1[i].Special_Attack+" "+winners_pokemon1[i].Def+" "+winners_pokemon1[i].Special_Def,0,listOfFiles[0]);
                            logger.Print("\t"+winners_pokemon2[i].Name+": "+winners_pokemon2[i].HP+" "+winners_pokemon2[i].Normal_Attack
                                    +" "+winners_pokemon2[i].Special_Attack+" "+winners_pokemon2[i].Def+" "+winners_pokemon2[i].Special_Def,0,listOfFiles[0]);
                        }

                        /* Arena a ales evenimentul vsOtherPokemon */
                        if (events[selected_event].equals("vsOtherPokemon")) {
                            logger.Print("Final Battle: "+trainers[0].list_of_pokemons[i].Name+" vs "
                                    +trainers[1].list_of_pokemons[i].Name, 0, listOfFiles[0]);

                            Fighter1 fighter1 = new Fighter1(winners_pokemon1[i], winners_pokemon2[i]);
                            Fighter2 fighter2 = new Fighter2(winners_pokemon2[i], winners_pokemon1[i]);
                            int keep_hp1 = winners_pokemon1[i].HP, keep_hp2 = winners_pokemon2[i].HP;
                            while(winners_pokemon1[i].HP > 0 && winners_pokemon2[i].HP > 0) {
                                ExecutorService executor = Executors.newFixedThreadPool(2);
                                executor.execute(fighter1);
                                executor.execute(fighter2);
                                executor.shutdown();
                                try {
                                    executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                logger.Print(fighter1.attacker.Name+" "+fighter1.type_of_attack+"\t"+fighter2.attacker.Name
                                        +" "+fighter2.type_of_attack,0,listOfFiles[0]);
                                logger.Print(fighter2.defender.Name+": "+fighter2.defender.HP+", Cooldown Ability1 "
                                        +fighter1.cooldown1+" , Cooldown Ability2 "+fighter1.cooldown2,0,listOfFiles[0]);
                                logger.Print(fighter1.defender.Name+": "+fighter1.defender.HP+", Cooldown Ability1 "
                                        +fighter2.cooldown1+" , Cooldown Ability2 "+fighter2.cooldown2,0,listOfFiles[0]);
                                logger.Print(fighter1.stuned+" "+fighter1.dodged+" "+fighter2.stuned+" "+fighter2.dodged, 0,listOfFiles[0]);
                                String aux1 = fighter1.stuned, aux2 = fighter1.dodged;
                                fighter1.stuned = fighter2.stuned;
                                fighter2.stuned = aux1;
                                fighter1.dodged = fighter2.dodged;
                                fighter2.dodged = aux2;
                                logger.Print(fighter1.stuned+" "+fighter1.dodged+" "+fighter2.stuned+" "+fighter2.dodged, 0, listOfFiles[0]);
                            }
                            if(winners_pokemon1[i].HP == winners_pokemon2[i].HP)
                                logger.Print("DRAW BETWEEN "+winners_pokemon1[i].Name+" and "+winners_pokemon2[i].Name,0,listOfFiles[0]);
                            else {
                                if (winners_pokemon1[i].HP > 0) {
                                    /* castigator -> +1 la toate campurile */
                                    winners_pokemon1[i].setHP(keep_hp1 + 1);
                                    if (winners_pokemon1[i].Normal_Attack != 0)
                                        winners_pokemon1[i].setNormal_Attack(winners_pokemon1[i].getNormal_Attack() + 1);
                                    else
                                        winners_pokemon1[i].setSpecial_Attack(winners_pokemon1[i].getSpecial_Attack() + 1);
                                    winners_pokemon1[i].setDef(winners_pokemon1[i].getDef() + 1);
                                    winners_pokemon1[i].setSpecial_Def(winners_pokemon1[i].getSpecial_Def() + 1);
                                    /* ii returnam pierzatorului hp-ul initial */
                                    winners_pokemon2[i].setHP(keep_hp2);
                                    logger.Print("AND THE WINNER IS: "+winners_pokemon1[i].Name+" "+winners_pokemon1[i].HP+" "
                                    +winners_pokemon1[i].Normal_Attack+" "+winners_pokemon1[i].Special_Attack+" "+winners_pokemon1[i].Def
                                    +" "+winners_pokemon1[i].Special_Def, 0, listOfFiles[0]);
                                }
                                else {
                                    /* castigator -> +1 la toate campurile */
                                    winners_pokemon2[i].setHP(keep_hp2 + 1);
                                    if (winners_pokemon2[i].Normal_Attack != 0)
                                        winners_pokemon2[i].setNormal_Attack(winners_pokemon2[i].getNormal_Attack() + 1);
                                    else
                                        winners_pokemon2[i].setSpecial_Attack(winners_pokemon2[i].getSpecial_Attack() + 1);
                                    winners_pokemon2[i].setDef(winners_pokemon2[i].getDef() + 1);
                                    winners_pokemon2[i].setSpecial_Def(winners_pokemon2[i].getSpecial_Def() + 1);
                                    /* ii returnam pierzatorului hp-ul initial */
                                    winners_pokemon1[i].setHP(keep_hp1);
                                    logger.Print("AND THE WINNER IS: "+winners_pokemon2[i].Name+" "+winners_pokemon2[i].HP+" "
                                            +winners_pokemon2[i].Normal_Attack+" "+winners_pokemon2[i].Special_Attack+" "+winners_pokemon2[i].Def
                                            +" "+winners_pokemon2[i].Special_Def, 0, listOfFiles[0]);
                                }
                            }
                            contor1 = 1;
                        }
                    }
                    /* se reseaza contorul 1 pentru perechea urmatoare de pokemoni */
                    contor1 = 0;
                    /* creste contorul 2 reprezentand numarul rundei curente */
                    contor2++;
                }

                /* Acum se calculeaza cel mai bun pokemon de la fiecare antrenor */
                int[] vector1 = new int[3];
                int[] vector2 = new int[3];
                for(int i = 0; i < 3; i++)
                    vector1[i] = Administration.Properties(winners_pokemon1[i]);
                for(int i = 0; i < 3; i++)
                    vector2[i] = Administration.Properties(winners_pokemon2[i]);
                /* Metoda Administration.Maximum intoarce indicele celui mai bun pokemon */
                Pokemon best_pokemon1 = winners_pokemon1[Administration.Maximum(vector1)];
                Pokemon best_pokemon2 = winners_pokemon2[Administration.Maximum(vector2)];

                /* Sa inceapa batalia finala */
                logger.Print("Final Battle between "+best_pokemon1.Name+" and "+best_pokemon2.Name,0,listOfFiles[0]);
                Fighter1 fighter1 = new Fighter1(best_pokemon1, best_pokemon2);
                Fighter2 fighter2 = new Fighter2(best_pokemon2, best_pokemon1);
                int keep_hp1 = best_pokemon1.HP, keep_hp2 = best_pokemon2.HP;
                while(best_pokemon1.HP > 0 && best_pokemon2.HP > 0) {
                        ExecutorService executor = Executors.newFixedThreadPool(2);
                        executor.execute(fighter1);
                        executor.execute(fighter2);
                        executor.shutdown();
                        try {
                            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        logger.Print(fighter1.attacker.Name+" "+fighter1.type_of_attack+"\t"+fighter2.attacker.Name
                                +" "+fighter2.type_of_attack,0,listOfFiles[0]);
                        logger.Print(fighter2.defender.Name+": "+fighter2.defender.HP+", Cooldown Ability1 "
                                +fighter1.cooldown1+" , Cooldown Ability2 "+fighter1.cooldown2,0,listOfFiles[0]);
                        logger.Print(fighter1.defender.Name+": "+fighter1.defender.HP+", Cooldown Ability1 "
                                +fighter2.cooldown1+" , Cooldown Ability2 "+fighter2.cooldown2,0,listOfFiles[0]);
                        logger.Print(fighter1.stuned+" "+fighter1.dodged+" "+fighter2.stuned+" "+fighter2.dodged, 0,listOfFiles[0]);
                        String aux1 = fighter1.stuned, aux2 = fighter1.dodged;
                        fighter1.stuned = fighter2.stuned;
                        fighter2.stuned = aux1;
                        fighter1.dodged = fighter2.dodged;
                        fighter2.dodged = aux2;
                        logger.Print(fighter1.stuned+" "+fighter1.dodged+" "+fighter2.stuned+" "+fighter2.dodged, 0, listOfFiles[0]);
                }
                    /* S-a terminat batalia, deci hai sa vedem rezultatele */
                    if(best_pokemon1.HP == best_pokemon2.HP)
                        logger.Print("DRAW BETWEEN "+best_pokemon1.Name+" and "+best_pokemon2.Name,0,listOfFiles[0]);
                    else {
                        if (best_pokemon1.HP > 0) {
                            best_pokemon1.setHP(keep_hp1 + 1);
                            if (best_pokemon1.Normal_Attack != 0)
                                best_pokemon1.setNormal_Attack(best_pokemon1.getNormal_Attack() + 1);
                            else
                                best_pokemon1.setSpecial_Attack(best_pokemon1.getSpecial_Attack() + 1);
                            best_pokemon1.setDef(best_pokemon1.getDef() + 1);
                            best_pokemon1.setSpecial_Def(best_pokemon1.getSpecial_Def() + 1);
                            /* ii returnam pierzatorului hp-ul initial */
                            best_pokemon2.setHP(keep_hp2);

                            /* se creeaza cu ajutorul design pattern-ului Singleton o instanta unica care reprezinta castigatorul final */
                            Singleton singleton = Singleton.getInstance();
                            singleton.final_winner = best_pokemon1;
                            logger.Print("THE ABSOLUT WINNER IS: "+singleton.final_winner.Name+" "+singleton.final_winner.HP+" "
                            +singleton.final_winner.Normal_Attack+" "+singleton.final_winner.Special_Attack+" "+singleton.final_winner.Def
                            +" "+singleton.final_winner.Special_Def,0,listOfFiles[0]);
                        }
                        else {
                            best_pokemon2.setHP(keep_hp2 + 1);
                            if (best_pokemon2.Normal_Attack != 0)
                                best_pokemon2.setNormal_Attack(best_pokemon2.getNormal_Attack() + 1);
                            else
                                best_pokemon2.setSpecial_Attack(best_pokemon2.getSpecial_Attack() + 1);
                            best_pokemon2.setDef(best_pokemon2.getDef() + 1);
                            best_pokemon2.setSpecial_Def(best_pokemon2.getSpecial_Def() + 1);
                            /* ii returnam pierzatorului hp-ul initial */
                            best_pokemon1.setHP(keep_hp1);

                            /* se creeaza cu ajutorul design pattern-ului Singleton o instanta unica care reprezinta castigatorul final */
                            Singleton singleton = Singleton.getInstance();
                            singleton.final_winner = best_pokemon2;
                            logger.Print("THE ABSOLUT WINNER IS: "+singleton.final_winner.Name+" "+singleton.final_winner.HP+" "
                                    +singleton.final_winner.Normal_Attack+" "+singleton.final_winner.Special_Attack+" "+singleton.final_winner.Def
                                    +" "+singleton.final_winner.Special_Def,0,listOfFiles[0]);
                        }
                    }
            }
            contor = 0;
            logger.Print("--------------------------------------------------------", 0, listOfFiles[0]);
        }

    }
}



