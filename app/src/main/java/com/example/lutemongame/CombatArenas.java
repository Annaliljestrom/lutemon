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

//    public void trainingArena() {
//
////        Lutemon dummy = new Lutemon();
////        dummy.chosenColorNumber(6);
////        dummy.lutemon(dummy.getColor(), "Dummy", 0);
//
//        Lutemon lutemon1 = Inventory.getBattleLutemons().get(0);
//        Lutemon lutemon2 = Inventory.getBattleLutemons().get(1);
//
//
//
//        boolean y = true;
//        // taistelu
//
//        while (y == true) {
//            String abilityName= "Nuijanukutus";
//            lutemon.listAbilities();
//            Integer valittuabilityName = Integer.parseInt(scan.nextLine());
//
//            switch (valittuabilityName){
//                case 1:
//                    lutemon.setAbilityDamage(lutemon.getAbilityDamage(valittuabilityName-1));
//                    abilityName= lutemon.getAbilityName(valittuabilityName-1);
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
//            CombatCalculations.damageLutemon(lutemon, dummy);
//            int damage = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon, dummy));
//
//            System.out.println(lutemon.getName() + " käyttää kyvyn '" + abilityName + "'! ");
//            System.out.println(dummy.getName() + " ottaa " + damage + " verran vahinkoa");
//            dummy.setHealth(dummy.getHealth() - damage);
//            System.out.println(dummy.getName() + " nykyinen HP on " + dummy.getHealth() + "/" + dummy.getmaxHP());
//            if (dummy.getHealth() <= 0 || lutemon.getHealth() <= 0) {
//                y = false;
//                CombatCalculations.checkIfAlive(lutemon, dummy);
//                break;
//            }
//            int damage2 = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(dummy, lutemon));
//
//            System.out.println(dummy.getName() + " Käyttää kyvyn 'Trash Talk'");
//            System.out.println(lutemon.getName() + " on melkein immuuni kyvylle");
//            System.out.println(lutemon.getName() + " ottaa " + damage2 + " verran vahinkoa");
//            lutemon.setHealth(lutemon.getHealth() - damage2);
//            System.out.println(
//                    lutemon.getName() + " nykyinen HP on " + lutemon.getHealth() + "/" + lutemon.getmaxHP() + "\n");
//
//            if (dummy.getHealth() <= 0 || lutemon.getHealth() <= 0) {
//                y = false;
//                CombatCalculations.checkIfAlive(lutemon, dummy);
//                break;
//            }
//
//        }
//        System.out.println("1) Taistele uudestaan 2) Palaa takaisin kotiin\n");
//        Integer v = Integer.parseInt(scan.nextLine());
//
//        switch (v) {
//            case 1:
//                if (lutemon.getHealth() > 0) {
//                    CombatArenas.trainingArena(lutemon, scan);
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
//
//    }
}
