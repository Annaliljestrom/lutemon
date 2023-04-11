package com.example.lutemongame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private static Inventory inventory = null;
    private HashMap<String, Integer> backpack = new HashMap<String, Integer>();
    private ArrayList<String> itemList = new ArrayList<>();

    public static ArrayList<Object> deadlutemons = new ArrayList<Object>();

    public static ArrayList<Object> lutemons = new ArrayList<Object>();
    // "potion" = "23";
    public static Inventory getInstance() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;

    }

    private Inventory() {
    }

    public void backpackContents() {
        int i = 0;
        System.out.println("Backpack contains: ");
        for (Map.Entry<String, Integer> r : inventory.getBackpack().entrySet()) {

            System.out.println(i+") "+r.getKey() + " " + r.getValue());
            inventory.getItemList().add(r.getKey());
            i++;

        }
        return;
    }

    public void resetBackpack() {
        backpack.replaceAll((k, v) -> 0);
        System.out.println("Backpack reseted");
        System.out.println(backpack.values());

    }

    public HashMap<String, Integer> getBackpack() {
        return backpack;
    }

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void addItem(String key) {
        if (backpack.containsKey(key)){
            backpack.merge(key, 1, (a, b) -> a + b);
        }else{
            backpack.put(key, 1);

        }
    }

    public void removeItem(String key) {
        if (backpack.containsKey(key)){
            backpack.merge(key, 1, (a, b) -> a - b);
        }
        else{
            backpack.put(key, 0);
        }

    }

    public void listItemList() {
        backpackContents();
    }
    public void selectItem(int selectedItemIndex){
        switch(selectedItemIndex){
            case 0:
                removeItem("Potion");

                itemTargetHeal(30);
                break;
            case 1:
                try{
                    removeItem("Revive potion");
                    reviveLutemon();

                }

                catch(IndexOutOfBoundsException e){
                    System.out.println("");
                }

                break;
            case 3:
                removeItem("Max potion");
                itemTargetHeal(999999);

            default :
                System.out.println("Invalid selection, returning");
                break;
        }



    }
    public void itemTargetHeal(int healAmount){
        try (Scanner scan2 = new Scanner(System.in)) {
            //getLutemons();
            //ArrayList <Object> lutemons;
            System.out.println("Select target");
            Lutemon.listLutemons(getLutemons());
            Integer selectedLutemon = Integer.parseInt(scan2.nextLine());
            if ( healAmount <= ((Lutemon) lutemons.get(selectedLutemon)).getmaxHP() ){
                ((Lutemon) lutemons.get(selectedLutemon)).setHealth(healAmount);
            }
            else{
                ((Lutemon) lutemons.get(selectedLutemon)).setHealth(((Lutemon) lutemons.get(selectedLutemon)).getmaxHP());
            }
            System.out.print(((Lutemon) lutemons.get(selectedLutemon)).getName()+" healed. Current HP "+((Lutemon) lutemons.get(selectedLutemon)).getHealth()+"/"+((Lutemon) lutemons.get(selectedLutemon)).getHealth()+"\n\n");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void reviveLutemon( ){
        if (deadlutemons.isEmpty()){
            System.out.println("No valit targets");
        }
        else{
            try (Scanner scan3 = new Scanner(System.in)) {
                Lutemon.listLutemons(deadlutemons);
                System.out.println("Select target");
                Integer selectedLutemon = Integer.parseInt(scan3.nextLine());
                ((Lutemon) deadlutemons.get(selectedLutemon)).setHealth(( (Lutemon) deadlutemons.get(selectedLutemon)).getmaxHP()/2);
                System.out.println("Lutemon is revived\n");
                deadlutemons.remove(selectedLutemon);
                lutemons.add(selectedLutemon);

            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static ArrayList<Object> getLutemons(){
        return lutemons;
    }
}
