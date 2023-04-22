package com.example.lutemongame;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Lutemon extends AppCompatActivity {
    private String name;
    private int attack;
    private int defence;
    private int experience = 0;
    private int health;
    private int maxhp;
    private int id;
    private int taso;
    private int abilityDamage;
    private ColorType Type;
    HashMap <String, Integer> abilitiesMap = new HashMap<>();
    private ArrayList<String> abilitiesList = new ArrayList<>();

    private HashMap<String, Integer> stats = new HashMap<>();

    enum ColorType {
        WHITE,
        BLACK,
        GREEN,
        PINK,
        ORANGE,
        DUMMY,
        GYM,
    }



    public void scoreReset() {
        //more stats to be added here
        stats.put("wins", 0);
    }

    public void chosenColorNumber(Integer c) {

        if (c == 1) {
            Type = ColorType.WHITE;
        }
        if (c == 2) {
            Type = ColorType.GREEN;
        }
        if (c == 3) {
            Type = ColorType.PINK;
        }
        if (c == 4) {
            Type = ColorType.ORANGE;
        }
        if (c == 5) {
            Type = ColorType.BLACK;
        }
        if (c == 6) {
            Type = ColorType.DUMMY;
        }
        setColor(Type);

        return;
    }

    public void lutemon(ColorType Type, String name, int id) {
        // give different type of Lutemon2
        switch (Type) {
            case WHITE:

                attack = 5;
                defence = 4;
                maxhp = 20;
                health = 20;
                taso = 0;
                abilitiesMap.put("Nuijanukutus", 5);
                //abilitiesMap.put("Sleep", 10);
                break;

            case BLACK:

                attack = 9;
                defence = 0;
                maxhp = 16;
                health = 16;
                taso = 0;
                break;

            case GREEN:

                attack = 6;
                defence = 3;
                maxhp = 19;
                health = 19;
                taso = 0;
                break;

            case PINK:

                attack = 7;
                defence = 2;
                maxhp = 18;
                health = 18;
                taso = 0;
                break;

            case ORANGE:

                attack = 8;
                defence = 1;
                maxhp = 17;
                health = 17;
                taso = 0;
                break;

            case DUMMY:

                attack = 8;
                defence = 2;
                maxhp = 20;
                health = 20;
                taso = 0;
                abilitiesMap.put("Trash Talk", 5);
                break;
            case GYM:
                attack = 1;
                defence = 3;
                maxhp = 50;
                health = 50;
                taso = 0;
                abilitiesMap.put("Punch", 2);

            default:

                break;
        }

        this.name = name;
        this.id = id;

    }

    public void createLutemon(Lutemon lutemon, String name, int id){

        //System.out.println("Give lutemon a name\n");
        //String name = scan.nextLine();
        //System.out.println("Mikä väri?\n 1) Valkoinen, 2) Vihreä, 3) Pinkki, 4) Oranssi, 5) Musta\n");
        //Integer c = Integer.parseInt(scan.nextLine());
        //lutemon.chosenColorNumber(c);
        //System.out.println("väri on " + lutemon.getColor());
        lutemon.lutemon(lutemon.getColor(), name, id);
        Inventory.lutemons.add(lutemon);
        Lutemon dummy = new Lutemon();
        dummy.chosenColorNumber(6);
        dummy.lutemon(dummy.getColor(), "Dummy", 0);
        dummy.setHealth(0);
        Inventory.deadlutemons.add(dummy);

        lutemon.scoreReset();
        id++;
    }
    public static void listLutemons(ArrayList<Lutemon> lutemons) {
        for (Object lutemon: lutemons){
            System.out.println(
                    "Lutemon " + ((Lutemon) lutemon).getId() + "\nnimi = " + ((Lutemon) lutemon).getName() + "\n");
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return this.health;
    }

    public String getName() {
        return this.name;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getmaxHP() {
        return this.maxhp;
    }

    public void setmaxHP(int maxhp) {
        this.maxhp = maxhp;
    }

    public ColorType getColor() {
        return this.Type;
    }

    public int getId() {
        return this.id;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getTaso() {
        return this.taso;
    }

    public void setTaso(double d) {
        this.taso = (int) d;
    }

    public void setColor(ColorType Type) {

        this.Type = Type;
        ;
    }

    public int getStats(String key) {

        return stats.get(key);
    }

    public void setStats(String key) {
        stats.put(key, stats.get(key) + 1);
    }
    public void listAbilities(){
        int i = 1;
        for (HashMap.Entry<String, Integer> set :
                abilitiesMap.entrySet()) {
            abilitiesList.add(set.getKey());
            System.out.println(i+" "+set.getKey() + " = "
                    + set.getValue()+" Damage");
            i++;
        }

    }

    public Integer getAbilityDamage(int valinta){
        String abilityName = abilitiesList.get(valinta);
        return abilitiesMap.get(abilityName);
    }
    public String getAbilityName(int valinta){
        String abilityName = abilitiesList.get(valinta);
        return abilityName;
    }
    public void setAbilityDamage(int abilityDamage){
        this.abilityDamage= abilityDamage;
    }
    public int getAbilityDamage(){
        return this.abilityDamage;
    }
    public void setName(String name){
        this.name=name;
    }
    public void printAllLutemonStats(){
        for (Object lutemon: Inventory.lutemons){
            System.out.println(
                    "Lutemon " + ((Lutemon) lutemon).getId() + "\nnimi = " + ((Lutemon) lutemon).getName());
            System.out.println("Attack = "+ ((Lutemon) lutemon).getAttack() + "\nDefence = " + ((Lutemon) lutemon).getDefence() + "\n" +"HP = "+
                    ((Lutemon) lutemon).getHealth()+"/"+((Lutemon)lutemon).getmaxHP()+"\nLevel = " +((Lutemon) lutemon).getTaso()+"\n"
            );
        }
        try{
            for (Object lutemon: Inventory.deadlutemons){
                System.out.println(
                        "Lutemon " + ((Lutemon) lutemon).getId() + "\nnimi = " + ((Lutemon) lutemon).getName());
                System.out.println("Attack = "+ ((Lutemon) lutemon).getAttack() + "\nDefence = " + ((Lutemon) lutemon).getDefence() + "\n" +"HP = "+
                        ((Lutemon) lutemon).getHealth()+"/"+((Lutemon)lutemon).getmaxHP()+"\nLevel = " +((Lutemon) lutemon).getTaso()+"\n"
                );
            }
        }catch(IndexOutOfBoundsException e){
        }


    }
}
