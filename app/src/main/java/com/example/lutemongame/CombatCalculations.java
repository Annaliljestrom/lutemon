package com.example.lutemongame;

import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.Inventory;
import com.example.lutemongame.Lutemon;

import java.util.concurrent.ThreadLocalRandom;

public class CombatCalculations {
    private static int defenceRoll;

    private static int attackDamageRoll;
    private static int attackDamage;

    public static int damageLutemon(Lutemon attacker, Lutemon defender) {
        // calculating attackdamage and defence number with random effect
        int attackDamageRoll = setAttackDamageRoll(attacker, defender);
        int defenceRoll = setDefenceRoll(defender);
        int damage = attackDamageRoll - defenceRoll;
        // minimum dmg is 1
        if (damage <= 0) {
            damage = 1;
        }
        return damage;
    }

    public static int setAttackDamageRoll(Lutemon attacker, Lutemon target) {
        // setting attack damage amount against target lutemon
        attackDamage = attacker.getAbilityDamage();
        randomizeAttackDamage(attackDamage);

        switch (attacker.getColor()) {
            case WHITE:
                if (target.getColor() == Lutemon.ColorType.GREEN || target.getColor() == Lutemon.ColorType.PINK) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 0.7*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.ORANGE) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 1.5*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.BLACK) {
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 2*attacker.getAttack();
                } else if (target.getColor() == Lutemon.ColorType.WHITE || target.getColor() == Lutemon.ColorType.DUMMY)
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 10*attacker.getAttack();
                break;
            case GREEN:
                if (target.getColor() == Lutemon.ColorType.GREEN || target.getColor() == Lutemon.ColorType.PINK) {
                    attackDamageRoll = (int) Math.round((randomizeAttackDamage(attackDamage) * 0.7*attacker.getAttack()));
                } else if (target.getColor() == Lutemon.ColorType.ORANGE) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 1.5*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.BLACK) {
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 2*attacker.getAttack();
                } else if (target.getColor() == Lutemon.ColorType.WHITE || target.getColor() == Lutemon.ColorType.DUMMY)
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 10*attacker.getAttack();
                break;
            case PINK:
                if (target.getColor() == Lutemon.ColorType.GREEN || target.getColor() == Lutemon.ColorType.PINK) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 0.7*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.ORANGE) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 1.5*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.BLACK) {
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 2*attacker.getAttack();
                } else if (target.getColor() == Lutemon.ColorType.WHITE || target.getColor() == Lutemon.ColorType.DUMMY)
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 10*attacker.getAttack();
                break;
            case ORANGE:
                if (target.getColor() == Lutemon.ColorType.GREEN || target.getColor() == Lutemon.ColorType.PINK) {
                    attackDamageRoll = (int) Math.round((randomizeAttackDamage(attackDamage) * 0.7*attacker.getAttack()));
                } else if (target.getColor() == Lutemon.ColorType.ORANGE) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 1.5*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.BLACK) {
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 2*attacker.getAttack();
                } else if (target.getColor() == Lutemon.ColorType.WHITE || target.getColor() == Lutemon.ColorType.DUMMY)
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 10*attacker.getAttack();
                break;
            case BLACK:
                if (target.getColor() == Lutemon.ColorType.GREEN || target.getColor() == Lutemon.ColorType.PINK) {
                    attackDamageRoll = (int) Math.round((randomizeAttackDamage(attackDamage) * 0.7*attacker.getAttack()));
                } else if (target.getColor() == Lutemon.ColorType.ORANGE) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 1.5*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.BLACK) {
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 2*attacker.getAttack();
                } else if (target.getColor() == Lutemon.ColorType.WHITE || target.getColor() == Lutemon.ColorType.DUMMY)
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 10*attacker.getAttack();
                break;
            case DUMMY:
                if (target.getColor() == Lutemon.ColorType.GREEN || target.getColor() == Lutemon.ColorType.PINK) {
                    attackDamageRoll = (int) Math.round((randomizeAttackDamage(attackDamage) * 0.7*attacker.getAttack()));
                } else if (target.getColor() == Lutemon.ColorType.ORANGE) {
                    attackDamageRoll = (int) Math.round(randomizeAttackDamage(attackDamage) * 1.5*attacker.getAttack());
                } else if (target.getColor() == Lutemon.ColorType.BLACK) {
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 2*attacker.getAttack();
                } else if (target.getColor() == Lutemon.ColorType.WHITE || target.getColor() == Lutemon.ColorType.DUMMY)
                    attackDamageRoll = randomizeAttackDamage(attackDamage) * 10*attacker.getAttack();
                break;

            default:
                break;
        }

        return attackDamage*(int)Math.round(1+attacker.getAttack()*0.1);

    }

    public static int setDefenceRoll(Lutemon defender) {
        // setting defence number to random from 0 to defender defence
        defenceRoll = ThreadLocalRandom.current().nextInt(1, defender.getDefence()+1);

        return defenceRoll;
    }

    public static int randomizeAttackDamage(int attackDamage) {
        if(attackDamage<=0){
            attackDamage=1;
        }
        return attackDamage = ThreadLocalRandom.current().nextInt(0 ,attackDamage);
    }

    public int getDefenceRoll() {
        return defenceRoll;
    }

    public static void evolving(Lutemon lutemon) {
        int oldLevel = lutemon.getLevel();

        lutemon.setLevel(Math.floor(0.5 + Math.sqrt((2 * lutemon.getExperience() + 0.25))));
        lutemon.setAttack((int) Math.round(lutemon.getAttack() + (0.3 * lutemon.getLevel())));
        lutemon.setDefence((int) Math.round(lutemon.getDefence() + (0.1 * lutemon.getLevel())));
        lutemon.setmaxHP((int) Math.round(lutemon.getmaxHP() + (0.5 * lutemon.getLevel())));
        BattleFightActivity.levelUp(oldLevel, lutemon.getLevel(),lutemon.getName());
        //getting new skills when leveling up
        if (lutemon.getLevel()>= 5){
            switch(lutemon.getColor()){
                case WHITE:
                    lutemon.abilitiesMap.put("Sleep", 10);
                    System.out.println(lutemon.getName()+" learned new ability 'Sleep'");
                    break;
                case BLACK:
                    break;
                case ORANGE:
                    break;
                case GREEN:
                    break;
                case PINK:
                    break;
                default:
                    break;
            }
        }


    }
    public static boolean checkIfAlive(Lutemon lutemon, Lutemon dummy) {
        if (dummy.getHealth() <= 0) {
            //setting winner name on screen
            BattleFightActivity.setWinner(lutemon.getName());
            lutemon.setVictories(+1);
            dummy.setDefeats(+1);

            System.out.println("Taistelun voittaja on " + lutemon.getName() + "\n");
            System.out.println(lutemon.getName() + " saa voitosta +2 exp\n");

            lutemon.setExperience(lutemon.getExperience() + 2);
            evolving(lutemon);
            System.out.println(
                    lutemon.getName() + " taso on nyt " + lutemon.getLevel() + "\nxp:tä on " + lutemon.getExperience());

            lutemon.setStats("wins");
            System.out.println("Voitot ovat " + lutemon.getStats("wins") + "\n");

            boolean y = false;
            return y;
        }

        if (lutemon.getHealth() <= 0) {
            BattleFightActivity.setWinner(dummy.getName());
            dummy.setVictories(+1);
            lutemon.setDefeats(+1);
            System.out.println("Taistelun voittaja " + dummy.getName());
            lutemon.setHealth(0);
            if (Inventory.lutemons.contains(lutemon)){
                Inventory.deadlutemons.add(lutemon);
                Inventory.lutemons.remove(lutemon);
            }


            System.out.println(lutemon.getName() + " is dead and needs to be revived");
            // add method to add dead lutemon to deadlutemons array list and function how to
            // revive that lutemon and restore stats??

            boolean y = false;
            return y;
        }

        else {
            return true;
        }

    }

    public static void statsReset(Lutemon lutemon) {
        lutemon.lutemon(lutemon.getColor(), lutemon.getName(), lutemon.getId());
    }
}
