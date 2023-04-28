package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Lutemon extends AppCompatActivity implements Serializable {
    private String name;
    private int attack;
    private int defence;
    private int experience = 0;
    private int health;
    private int maxhp;
    private int id;
    private int level;
    private int battles = 0;
    private int trainingDays = 0;
    private int victories = 0;

    public int getBattles() {
        return battles;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public int getVictories() {
        return victories;
    }

    public int getDefeats() {
        return defeats;
    }

    private int defeats = 0;

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public void setTrainingDays(int trainingDays) {
        this.trainingDays = trainingDays;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    private int abilityDamage;
    private ColorType Type;
    protected int image;
    HashMap <String, Integer> abilitiesMap = new HashMap<>();
    private ArrayList<String> abilitiesList = new ArrayList<>();

    private HashMap<String, Integer> stats = new HashMap<>();

    public enum ColorType {
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
        setImage(image);

        return;
    }

    public void lutemon(ColorType Type, String name, int id) {
        // give different type of Lutemon2
        switch (Type) {
            case WHITE:
                image = R.drawable.white_transparent;
                attack = 5;
                defence = 4;
                maxhp = 20;
                health = 20;
                level = 0;
                abilitiesMap.put("Meat mallet", 5);
                abilitiesMap.put("Poisonous fart", 5);
                //abilitiesMap.put("Sleep", 10);
                break;

            case BLACK:
                image = R.drawable.black_transparent;
                attack = 9;
                defence = 1;
                maxhp = 16;
                health = 16;
                level = 0;
                abilitiesMap.put("Meat mallet", 5);
                abilitiesMap.put("Disruptive meme", 5);
                break;

            case GREEN:
                image = R.drawable.green_transparent;
                attack = 6;
                defence = 3;
                maxhp = 19;
                health = 19;
                level = 0;
                abilitiesMap.put("Meat mallet", 5);
                abilitiesMap.put("Awkward stare", 5);
                break;

            case PINK:
                image = R.drawable.pink_transparent;
                attack = 7;
                defence = 2;
                maxhp = 18;
                health = 18;
                level = 0;
                abilitiesMap.put("Meat mallet", 5);
                abilitiesMap.put("Fit of rage", 5);
                break;

            case ORANGE:
                image = R.drawable.orange_transparent;
                attack = 8;
                defence = 1;
                maxhp = 17;
                health = 17;
                level = 0;
                abilitiesMap.put("Meat mallet", 5);
                abilitiesMap.put("Infectious bite of syphilis", 5);
                break;

            case DUMMY:
                image = R.drawable.dummy_transparent;
                attack = 8;
                defence = 2;
                maxhp = 20;
                health = 20;
                level = 0;
                abilitiesMap.put("Trash Talk", 5);
                break;
            case GYM:
                attack = 1;
                defence = 3;
                maxhp = 50;
                health = 50;
                level = 0;
                abilitiesMap.put("Punch", 2);

            default:

                break;
        }

        this.name = name;
        this.id = id;

    }

    public void createLutemon(Lutemon lutemon, String name, int id){

        lutemon.lutemon(lutemon.getColor(), name, id);
        Inventory.lutemons.add(lutemon);


        //Inventory.battleLutemons.add(dummy2);


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

    public int getLevel() {
        return this.level;
    }

    public void setLevel(double d) {
        this.level = (int) d;
    }

    public void setColor(ColorType Type) {
        this.Type = Type;
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
                    ((Lutemon) lutemon).getHealth()+"/"+((Lutemon)lutemon).getmaxHP()+"\nLevel = " +((Lutemon) lutemon).getLevel()+"\n"
            );
        }
        try{
            for (Object lutemon: Inventory.deadLutemons){
                System.out.println(
                        "Lutemon " + ((Lutemon) lutemon).getId() + "\nnimi = " + ((Lutemon) lutemon).getName());
                System.out.println("Attack = "+ ((Lutemon) lutemon).getAttack() + "\nDefence = " + ((Lutemon) lutemon).getDefence() + "\n" +"HP = "+
                        ((Lutemon) lutemon).getHealth()+"/"+((Lutemon)lutemon).getmaxHP()+"\nLevel = " +((Lutemon) lutemon).getLevel()+"\n"
                );
            }
        }catch(IndexOutOfBoundsException e){
        }
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public void getAbilityImage(){

    }
    public void resetHp(){
        this.setHealth(this.maxhp);
    }
}


