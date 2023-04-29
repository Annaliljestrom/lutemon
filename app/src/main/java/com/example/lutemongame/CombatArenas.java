package com.example.lutemongame;

public class CombatArenas {
    public CombatArenas() {
    }

    public static Boolean trainingArena(int abilityNumber) {

//        Lutemon dummy = new Lutemon();
//        dummy.chosenColorNumber(6);
//        dummy.lutemon(dummy.getColor(), "Dummy", 0);
        // Saving the two lutemons, that are going to fight, to the variables
        Lutemon lutemon1 = Inventory.getBattleLutemons().get(0);
        Lutemon lutemon2 = Inventory.getBattleLutemons().get(1);

        // Organising abilities to the list, in order to use them
        lutemon1.listAbilities();
        lutemon2.listAbilities();

        // Setting ability damage for clicked ability
        lutemon1.setAbilityDamage(lutemon1.getAbilityDamage(abilityNumber));
        lutemon2.setAbilityDamage(lutemon2.getAbilityDamage(abilityNumber));
        System.out.println(lutemon1.getAbilityDamage());

//      // Calculating the damage
        int damage = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon1, lutemon2));
        int damage2 = CombatCalculations.randomizeAttackDamage(CombatCalculations.damageLutemon(lutemon2, lutemon1));

        // Player's turn to hit
        System.out.println(lutemon1.getName() + " käyttää kyvyn '" + lutemon1.getAbilityName(abilityNumber)+"'! ");
        System.out.println(lutemon2.getName() + " ottaa " + damage + " verran vahinkoa");
        lutemon2.setHealth(lutemon2.getHealth() - damage);
        System.out.println(lutemon2.getName() + " nykyinen HP on " + lutemon2.getHealth() + "/" + lutemon2.getmaxHP());
        // Checking if both lutemons are still alive
        if (lutemon2.getHealth() <= 0 || lutemon1.getHealth() <= 0) {
            // If not, the battle ends
            CombatCalculations.checkIfAlive(lutemon1, lutemon2);
            System.out.println("Loppuu tässä2");
            return true;
        }
        // Opponent's turn to hit
        System.out.println(lutemon2.getName() + " Käyttää kyvyn 'Trash Talk'");
        System.out.println(lutemon1.getName() + " on melkein immuuni kyvylle");
        System.out.println(lutemon1.getName() + " ottaa " + damage2 + " verran vahinkoa");
        lutemon1.setHealth(lutemon1.getHealth() - damage2);
        System.out.println(
                lutemon1.getName() + " nykyinen HP on " + lutemon1.getHealth() + "/" + lutemon1.getmaxHP() + "\n");
        // Checking if both lutemons are still alive
        if (lutemon2.getHealth() <= 0 || lutemon1.getHealth() <= 0) {
            // If not, the battle ends
            CombatCalculations.checkIfAlive(lutemon1, lutemon2);
            System.out.println("Loppuu tässä");
            return true;
        }
        return false;
    }
}
