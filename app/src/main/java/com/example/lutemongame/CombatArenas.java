package com.example.lutemongame;

import android.content.Intent;
import android.view.View;

import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.Battle.BattleTabActivity1;
import com.example.lutemongame.Battle.TrainLutemonActivity;

import java.util.Scanner;

public class CombatArenas {

    public CombatArenas() {
    }

    public void trainingArena() {

//        Lutemon dummy = new Lutemon();
//        dummy.chosenColorNumber(6);
//        dummy.lutemon(dummy.getColor(), "Dummy", 0);

        Lutemon lutemon1 = Inventory.getBattleLutemons().get(0);
        Lutemon lutemon2 = Inventory.getBattleLutemons().get(1);



        boolean y = true;
        // taistelu

        while (y == true) {
            String abilityName= "Nuijanukutus";
            lutemon1.listAbilities();
            ///Käyttäjän input ability tähän

//            switch (chosenAbility){
//                case 1:
//                    lutemon1.setAbilityDamage(lutemon1.getAbilityDamage(chosenAbility-1));
//                    abilityName= lutemon1.getAbilityName(chosenAbility-1);
//                    break;
//                case 2:
//                    Inventory.getInstance();
//
//                    break;
//
//                default:
//                    abilityName="Nuijanukutus";
//
//            }
            CombatCalculations.damageLutemon(lutemon1, lutemon2);
            int damage = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon1, lutemon2));

            System.out.println(lutemon1.getName() + " käyttää kyvyn '" + abilityName + "'! ");
            System.out.println(lutemon2.getName() + " ottaa " + damage + " verran vahinkoa");
            lutemon2.setHealth(lutemon2.getHealth() - damage);
            System.out.println(lutemon2.getName() + " nykyinen HP on " + lutemon2.getHealth() + "/" + lutemon2.getmaxHP());
            if (lutemon2.getHealth() <= 0 || lutemon1.getHealth() <= 0) {
                y = false;
                CombatCalculations.checkIfAlive(lutemon1, lutemon2);
                break;
            }
            int damage2 = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon2, lutemon1));

            System.out.println(lutemon2.getName() + " Käyttää kyvyn 'Trash Talk'");
            System.out.println(lutemon1.getName() + " on melkein immuuni kyvylle");
            System.out.println(lutemon1.getName() + " ottaa " + damage2 + " verran vahinkoa");
            lutemon1.setHealth(lutemon1.getHealth() - damage2);
            System.out.println(
                    lutemon1.getName() + " nykyinen HP on " + lutemon1.getHealth() + "/" + lutemon1.getmaxHP() + "\n");

            if (lutemon2.getHealth() <= 0 || lutemon1.getHealth() <= 0) {
                y = false;
                CombatCalculations.checkIfAlive(lutemon1, lutemon2);
                break;
            }

        }
        System.out.println("1) Taistele uudestaan 2) Palaa takaisin kotiin\n");
        //Integer v = Integer.parseInt(scan.nextLine());

//        switch (v) {
//            case 1:
//                if (lutemon1.getHealth() > 0) {
//                    trainingArena();
//                } else {
//                    System.out.println("Lutemon is dead, returning back to base\n");
//                    return;
//                }
//
//            case 2:
//                break;
//            default:
//                break;
//
//        }

    }
}
