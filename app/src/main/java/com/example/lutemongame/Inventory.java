package com.example.lutemongame;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
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
    public void reviveLutemon( ){
        if (deadLutemons.isEmpty()){
            System.out.println("No valit targets");
        }
        else{
            try (Scanner scan3 = new Scanner(System.in)) {
                Lutemon.listLutemons(deadLutemons);
                System.out.println("Select target");
                Integer selectedLutemon = Integer.parseInt(scan3.nextLine());
                ((Lutemon) deadLutemons.get(selectedLutemon)).setHealth(( (Lutemon) deadLutemons.get(selectedLutemon)).getmaxHP()/2);
                System.out.println("Lutemon is revived\n");
                lutemons.add((Lutemon) deadLutemons.get(selectedLutemon));
                deadLutemons.remove(selectedLutemon);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(context.openFileOutput("savedLutemons.data", Context.MODE_PRIVATE));
            fileWriter.writeObject(lutemons);
            fileWriter.close();
            System.out.println("Valmista tuli!");
        } catch (IOException e) {
            System.out.println("pieleen meni");
        }
    }

    public static ArrayList<Lutemon> getBattleLutemons() {
        return battleLutemons;
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream fileReader = new ObjectInputStream(context.openFileInput("savedLutemons.data"));
            ArrayList<Lutemon> lutemonsToAdd = (ArrayList<Lutemon>) fileReader.readObject();
            int index = 0;
            int size = lutemonsToAdd.size();
            while (index < size) {
                Lutemon lutemon = lutemonsToAdd.get(index);
                lutemons.add(lutemon);
                index++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt.");
        } catch (IOException e) {
            System.out.println("Tiedoston lukeminen ei onnistunut.");
        } catch (ClassNotFoundException e) {
            System.out.println("Tiedoston lukeminen ei onnistunut");
        }
    }

    public static ArrayList<Lutemon> getLutemons(){
        return lutemons;
    }
    public static ArrayList<Lutemon> getDeadLutemons(){
        return lutemons;
    }
}
