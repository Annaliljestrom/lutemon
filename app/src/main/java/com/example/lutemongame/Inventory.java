package com.example.lutemongame;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private static Inventory inventory = null;
    private HashMap<String, Integer> backpack = new HashMap<String, Integer>();
    private ArrayList<String> itemList = new ArrayList<>();

    public static ArrayList<Lutemon> deadLutemons = new ArrayList<Lutemon>();

    public static ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
    public static ArrayList<Lutemon> battleLutemons = new ArrayList<Lutemon>();
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
    public ArrayList<Lutemon> getLutemonsList() {
        return lutemons;
    }

    public void addItem(String key) {
        if (backpack.containsKey(key)){
            backpack.merge(key, 1, (a, b) -> a + b);
        }else{
            backpack.put(key, 1);

        }
    }

    public void addItem2(String item) {
        this.itemList.add(item);
    }

    public void removeItem(String key) {
        if (backpack.containsKey(key)){
            backpack.merge(key, 1, (a, b) -> a - b);
        }
        else{
            backpack.put(key, 0);
        }
    }


    public void itemTargetHeal(int healAmount){
        try (Scanner scan2 = new Scanner(System.in)) {
            //getLutemons();
            //ArrayList <Object> lutemons;
            System.out.println("Select target");
            // Lutemon.listLutemons(getLutemons());
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


    public void saveLutemons(Context context) {
        // Creating a list that will be saved in to the file
        ArrayList<ArrayList<Lutemon>> lutemonsToSave = new ArrayList<ArrayList<Lutemon>>();
        // Adding alive and dead lutemons to the list
        lutemonsToSave.add(lutemons);
        lutemonsToSave.add(deadLutemons);
        try {
            // Writing the file "savedLutemons.data
            ObjectOutputStream fileWriter = new ObjectOutputStream(context.openFileOutput("savedLutemons.data", Context.MODE_PRIVATE));
            fileWriter.writeObject(lutemonsToSave);
            fileWriter.close();
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("The writing didn't work");
        }
    }

    public static ArrayList<Lutemon> getBattleLutemons() {
        return battleLutemons;
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream fileReader = new ObjectInputStream(context.openFileInput("savedLutemons.data"));
            // Reading the file, in order to get both alive and dead lutemons
            ArrayList<ArrayList<Lutemon>> lutemonsToLoad = (ArrayList<ArrayList<Lutemon>>) fileReader.readObject();
            // Saving alive and dead lutemons to different lists
            ArrayList<Lutemon> lutemonsToLoadAlive = lutemonsToLoad.get(0);
            ArrayList<Lutemon> lutemonsToLoadDead = lutemonsToLoad.get(1);
            // Adding alive lutemons to game's lutemons list
            int n = 0;
            int sizeAlive = lutemonsToLoadAlive.size();
            while (n < sizeAlive) {
                Lutemon lutemon = lutemonsToLoadAlive.get(n);
                lutemons.add(lutemon);
                n++;
            }
            // Adding dead lutemons to game's dead lutemons list
            int m = 0;
            int sizeDead = lutemonsToLoadDead.size();
            while (m < sizeDead) {
                Lutemon lutemon = lutemonsToLoadDead.get(m);
                deadLutemons.add(lutemon);
                m++;
            }
            fileReader.close();
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("The reading didn't work");
        } catch (ClassNotFoundException e) {
            System.out.println("The reading didn't work");
        }
    }

    public static ArrayList<Lutemon> getLutemons(){
        return lutemons;
    }
    public static ArrayList<Lutemon> getDeadLutemons(){
        return deadLutemons;
    }
}
