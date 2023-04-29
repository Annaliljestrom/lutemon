package com.example.lutemongame;

import com.example.lutemongame.Battle.BattleFightActivity;

import java.util.concurrent.ThreadLocalRandom;

public class CombatCalculations {
    private static int defenceRoll;
    private static int attackDamageRoll;
    private static int attackDamage;

    public static int damageLutemon(Lutemon attacker, Lutemon defender) {
        // Calculating attack damage and defence number with random effect
        int attackDamageRoll = setAttackDamageRoll(attacker, defender);
        int defenceRoll = setDefenceRoll(defender);
        int damage = attackDamageRoll - defenceRoll;
        // Minimum damage is 1
        if (damage <= 0) {
            damage = 1;
        }
        return damage;
    }

    public static int setAttackDamageRoll(Lutemon attacker, Lutemon target) {
        // Setting attack damage amount against target lutemon
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
        // Setting defence number to random from 0 to defender defence
        defenceRoll = ThreadLocalRandom.current().nextInt(1, defender.getDefence()+1);

        return defenceRoll;
    }

    public static int randomizeAttackDamage(int attackDamage) {
        // Minimum damage is 1
        if(attackDamage<=0){
            attackDamage=1;
        }
        return attackDamage = ThreadLocalRandom.current().nextInt(0 ,attackDamage);
    }

    public int getDefenceRoll() {
        return defenceRoll;
    }

    public static void evolving(Lutemon lutemon) {
        // A lutemon evolves if it has enough experience points
        int oldLevel = lutemon.getLevel();
        lutemon.setLevel(Math.floor(0.5 + Math.sqrt((2 * lutemon.getExperience() + 0.25))));
        lutemon.setAttack((int) Math.round(lutemon.getAttack() + (0.3 * lutemon.getLevel())));
        lutemon.setDefence((int) Math.round(lutemon.getDefence() + (0.1 * lutemon.getLevel())));
        lutemon.setmaxHP((int) Math.round(lutemon.getmaxHP() + (0.5 * lutemon.getLevel())));
        BattleFightActivity.levelUp(oldLevel, lutemon.getLevel(),lutemon.getName());
        // Getting possible new abilities when lutemon is leveling up
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
    public static boolean checkIfAlive(Lutemon lutemon1, Lutemon lutemon2) {
        if (lutemon2.getHealth() <= 0) {
            // Updating lutemons' stats
            BattleFightActivity.updateStats(lutemon1, lutemon2);
            // Setting winner name on screen
            System.out.println("Taistelun voittaja on " + lutemon1.getName() + "\n");
            System.out.println(lutemon1.getName() + " saa voitosta +2 exp\n");
            // Adding experience points to the winner lutemon
            lutemon1.setExperience(lutemon1.getExperience() + 2);
            evolving(lutemon1);
            // Telling the stats of the winner lutemon
            System.out.println(
                    lutemon1.getName() + " taso on nyt " + lutemon1.getLevel() + "\nxp:tä on " + lutemon1.getExperience());
            System.out.println("Voitot ovat " + lutemon1.getVictories() + "\n");
            boolean y = true;
            if (Inventory.lutemons.contains(lutemon2)){
                Inventory.deadLutemons.add(lutemon2);
                Inventory.lutemons.remove(lutemon2);
            }
            return y;
        }

        if (lutemon1.getHealth() <= 0) {
            // Updating lutemons' stats
            BattleFightActivity.updateStats(lutemon2, lutemon1);
            System.out.println("Taistelun voittaja " + lutemon2.getName());
            // Setting the dead lutemon's health to 0 and moving it to dead lutemons list
            lutemon1.setHealth(0);
            if (Inventory.lutemons.contains(lutemon1)){
                Inventory.deadLutemons.add(lutemon1);
                Inventory.lutemons.remove(lutemon1);
            }
            System.out.println(lutemon1.getName() + " is dead and needs to be revived");
            boolean y = true;
            return y;
        }
        else {
            return true;
        }
    }
}