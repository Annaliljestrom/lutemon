package com.example.lutemongame;

import java.util.Scanner;

public class CombatArenas {
    public CombatArenas() {

    }

    public static void trainingArena(Lutemon lutemon, Scanner scan) {
        Lutemon dummy = new Lutemon();
        dummy.chosenColorNumber(6);
        dummy.lutemon(dummy.getColor(), "Dummy", 0);



        System.out.println("1: " + lutemon.getName() + " att= " + lutemon.getAttack() + "; def= " + lutemon.getDefence()
                + "; exp= " + lutemon.getExperience() + "; health= " + lutemon.getHealth() + "/" + lutemon.getmaxHP()
                + ";");
        System.out.println(
                "2: " + dummy.getName() + " att= " + dummy.getAttack() + "; def= " + dummy.getDefence() + "; exp= "
                        + dummy.getExperience() + "; health= " + dummy.getHealth() + "/" + dummy.getmaxHP() + ";\n");

        boolean y = true;
        // taistelu

        while (y == true) {
            String abilityName= "Nuijanukutus";
            lutemon.listAbilities();
            Integer valittuabilityName = Integer.parseInt(scan.nextLine());

            switch (valittuabilityName){
                case 1:
                    lutemon.setAbilityDamage(lutemon.getAbilityDamage(valittuabilityName-1));
                    abilityName= lutemon.getAbilityName(valittuabilityName-1);
                    break;
                case 2:
                    Inventory.getInstance();

                    break;

                default:
                    abilityName="Nuijanukutus";

            }
            CombatCalculations.damageLutemon(lutemon, dummy);
            int damage = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon, dummy));

            System.out.println(lutemon.getName() + " käyttää kyvyn '" + abilityName + "'! ");
            System.out.println(dummy.getName() + " ottaa " + damage + " verran vahinkoa");
            dummy.setHealth(dummy.getHealth() - damage);
            System.out.println(dummy.getName() + " nykyinen HP on " + dummy.getHealth() + "/" + dummy.getmaxHP());
            if (dummy.getHealth() <= 0 || lutemon.getHealth() <= 0) {
                y = false;
                CombatCalculations.checkIfAlive(lutemon, dummy);
                break;
            }
            int damage2 = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(dummy, lutemon));

            System.out.println(dummy.getName() + " Käyttää kyvyn 'Trash Talk'");
            System.out.println(lutemon.getName() + " on melkein immuuni kyvylle");
            System.out.println(lutemon.getName() + " ottaa " + damage2 + " verran vahinkoa");
            lutemon.setHealth(lutemon.getHealth() - damage2);
            System.out.println(
                    lutemon.getName() + " nykyinen HP on " + lutemon.getHealth() + "/" + lutemon.getmaxHP() + "\n");

            if (dummy.getHealth() <= 0 || lutemon.getHealth() <= 0) {
                y = false;
                CombatCalculations.checkIfAlive(lutemon, dummy);
                break;
            }

        }
        System.out.println("1) Taistele uudestaan 2) Palaa takaisin kotiin\n");
        Integer v = Integer.parseInt(scan.nextLine());

        switch (v) {
            case 1:
                if (lutemon.getHealth() > 0) {
                    CombatArenas.trainingArena(lutemon, scan);
                } else {
                    System.out.println("Lutemon is dead, returning back to base\n");
                    return;
                }

            case 2:
                break;
            default:
                break;

        }

    }
}
