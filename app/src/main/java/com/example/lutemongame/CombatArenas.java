package com.example.lutemongame;

import com.example.lutemongame.Battle.BattleFightActivity;

public class CombatArenas {

    public CombatArenas() {
    }

    public static Boolean trainingArena(int abilityNumber) {

//        Lutemon dummy = new Lutemon();
//        dummy.chosenColorNumber(6);
//        dummy.lutemon(dummy.getColor(), "Dummy", 0);

        Lutemon lutemon1 = Inventory.getBattleLutemons().get(0);
        Lutemon lutemon2 = Inventory.getBattleLutemons().get(1);

        //järjestetään abilityt järjestyksessä listaan, jotta saadaan käytettyä niitä
        lutemon1.listAbilities();
        lutemon2.listAbilities();

        //setting ability damage for clicked ability
        lutemon1.setAbilityDamage(lutemon1.getAbilityDamage(abilityNumber));
        lutemon2.setAbilityDamage(lutemon2.getAbilityDamage(abilityNumber));
        System.out.println(lutemon1.getAbilityDamage());
//      //calculating damage
        int damage = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon1, lutemon2));
        int damage2 = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon2, lutemon1));

        //Player turn to hit
        System.out.println(lutemon1.getName() + " käyttää kyvyn '" + lutemon1.getAbilityName(abilityNumber)+"'! ");
        System.out.println(lutemon2.getName() + " ottaa " + damage + " verran vahinkoa");
        lutemon2.setHealth(lutemon2.getHealth() - damage);
        System.out.println(lutemon2.getName() + " nykyinen HP on " + lutemon2.getHealth() + "/" + lutemon2.getmaxHP());
        //checking if both lutemons are still alive
        if (lutemon2.getHealth() <= 0 || lutemon1.getHealth() <= 0) {
            CombatCalculations.checkIfAlive(lutemon1, lutemon2);
            System.out.println("Loppuu tässä2");
            return true;
        }
        //Opponent turn to hit
        System.out.println(lutemon2.getName() + " Käyttää kyvyn 'Trash Talk'");
        System.out.println(lutemon1.getName() + " on melkein immuuni kyvylle");
        System.out.println(lutemon1.getName() + " ottaa " + damage2 + " verran vahinkoa");
        lutemon1.setHealth(lutemon1.getHealth() - damage2);
        System.out.println(
                lutemon1.getName() + " nykyinen HP on " + lutemon1.getHealth() + "/" + lutemon1.getmaxHP() + "\n");
        //checking if both lutemons are still alive
        if (lutemon2.getHealth() <= 0 || lutemon1.getHealth() <= 0) {
            CombatCalculations.checkIfAlive(lutemon1, lutemon2);
            System.out.println("Loppuu tässä");
            return true;
        }
        return false;
    }
}
