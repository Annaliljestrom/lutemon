package com.example.lutemongame;

public class Encounter extends Campaign{
    private String name;


    public Encounter(String name){
        this.name=name;
    }

    public void createEncounters(){
        Lutemon gymEncounter1 = new Lutemon();
        gymEncounter1.setColor(Lutemon.ColorType.WHITE);
        gymEncounter1.setAttack(5);
        gymEncounter1.setName("Snorlax");
        gymEncounter1.setDefence(3);
        gymEncounter1.setmaxHP(200);
        gymEncounter1.setHealth(gymEncounter1.getmaxHP());
        gymEncounter1.abilitiesMap.remove("Punch",2);
        gymEncounter1.abilitiesMap.put("Sleep", 0);
        encounters.add(gymEncounter1);
    }
}
