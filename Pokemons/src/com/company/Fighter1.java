package com.company;

import java.util.Objects;
import java.util.Random;

    public class Fighter1 extends Main implements Runnable{
        Pokemon attacker, defender;
        String dodged = null, stuned = null, type_of_attack = null;
        int cooldown1 = 0, cooldown2 = 0;
        public Fighter1(Pokemon attacker, Pokemon defender) {
            this.attacker = attacker;
            this.defender = defender;
        }
        public void run() {
            type_of_attack = "No attack";
            if(cooldown1 != 0) cooldown1 = cooldown1 - 1;
            if(cooldown2 != 0) cooldown2 = cooldown2 - 1;

            /* cream comenzile antrenorului */
            Ordinay_Attack command1 = new Ordinay_Attack();
            Ability1 command2 = new Ability1();
            Ability2 command3 = new Ability2();
            Command[] list_of_commands = new Command[3];
            list_of_commands[0] = command1;
            list_of_commands[1] = command2;
            list_of_commands[2] = command3;
            Random rand = new Random();

            int selected_command = rand.nextInt(3);
            /* verificam daca pokemonul se fereste */
            if (!Objects.equals(dodged, "Yes")) {
                /* verificam daca pokemonul poate sa atace */
                if (Objects.equals(stuned, "No") || stuned == null) {

                    /* comanda aleasa este Ordinay Attack */
                    if (list_of_commands[selected_command] == command1) {
                        type_of_attack = "Ordinary Attack";
                        OrdinaryAttack();
                    }

                    /* comanda aleasa este Ability1 */
                    if (list_of_commands[selected_command] == command2) {
                        /* verificam daca abilitatea este disponibila */
                        if (cooldown1 == 0) {
                            type_of_attack = "Ability1";
                            Ability(command2);
                            cooldown1 = Integer.parseInt(command2.execut_command(attacker)[3]);
                        }
                        else {
                            Random rand1 = new Random();
                            int c1 = rand1.nextInt(2);
                            Command[] list1 = new Command[2];
                            list1[0] = command1;
                            list1[1] = command3;
                            if (list1[c1] == command1) {
                                type_of_attack = "Ordinary Attack";
                                OrdinaryAttack();
                            }
                            if (list1[c1] == command3)
                                if (cooldown2 == 0) {
                                    type_of_attack = "Ability2";
                                    Ability(command3);
                                    cooldown2 = Integer.parseInt(command3.execut_command(attacker)[3]);
                                }
                                else {
                                    type_of_attack = "Ordinary Attack";
                                    OrdinaryAttack();
                                }
                        }
                    }

                    /* comanda aleasa este Ability2 */
                    if (list_of_commands[selected_command] == command3) {
                        if (cooldown2 == 0) {
                            type_of_attack = "Ability2";
                            Ability(command3);
                            cooldown2 = Integer.parseInt(command3.execut_command(attacker)[3]);
                        } else {
                            Random rand2 = new Random();
                            int c2 = rand2.nextInt(2);
                            Command[] list2 = new Command[2];
                            list2[0] = command1;
                            list2[1] = command2;
                            if (list2[c2] == command1) {
                                type_of_attack = "Ordinary Attack";
                                OrdinaryAttack();
                            }
                            if (list2[c2] == command2)
                                if (cooldown1 == 0) {
                                    type_of_attack = "Ability1";
                                    Ability(command2);
                                    cooldown1 = Integer.parseInt(command2.execut_command(attacker)[3]);
                                } else {
                                    type_of_attack = "Ordinary Attack";
                                    OrdinaryAttack();
                                }
                        }
                    }

                }
                else {
                    stuned = null;
                    dodged = null;
                }
            }
            else
                dodged = null;
        }

        public void OrdinaryAttack() {
            if (attacker.getNormal_Attack() != 0)
                defender.setHP(defender.getHP() - attacker.getNormal_Attack() + defender.getDef());
            else
                defender.setHP(defender.getHP() - attacker.getSpecial_Attack() + defender.getSpecial_Def());
        }
        public void Ability(Command command) {
            int damage = Integer.parseInt(command.execut_command(attacker)[0]);
            defender.setHP(defender.getHP() - damage);
            dodged = command.execut_command(attacker)[2];
            stuned = command.execut_command(attacker)[1];
        }
}
