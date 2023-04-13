package com.example.lutemongame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {

    static HashMap<String, Integer> reppu = new HashMap<String, Integer>();

    public ArrayList<String> repunSisältö() {
        ArrayList<String> itemList = new ArrayList<>();
        System.out.println("repun sisältö on: \n");
        for (Map.Entry<String, Integer> r : reppu.entrySet()) {
            System.out.println(r.getKey() + " " + r.getValue());
            itemList.add(r.getKey());

        }
        return itemList;
    }

    public void resetReppu() {
        reppu.replaceAll((k, v) -> 0);
        System.out.println("Reppu resetattu");
        System.out.println(reppu.values());

    }

    public void repunToiminnot(Storage s, Scanner scan, Lutemon l, ArrayList<Lutemon> lutemons) {
        System.out.println("1) käytä esine 2) Palaa takaisin");
        Integer selectionreppu = Integer.parseInt(scan.nextLine());

        switch (selectionreppu) {

            case 1:
                ArrayList<String> itemList = s.repunSisältö();
                int i = 0;
                for (String item : itemList) {
                    System.out.println(i + " Käytä " + item);
                    i++;
                }

                Integer chosenItem = Integer.parseInt(scan.nextLine());
                String item = itemList.get(chosenItem);
                // checking if a lutemon is created
                if (lutemons.isEmpty()) {
                    System.out.println("Try creating a lutemon first");
                    return;
                } else {
                    useItem(item);
                    System.out.println("Valitse kohde");
                    Lutemon.listLutemons(lutemons);
                    Integer kohde = Integer.parseInt(scan.nextLine());
                    try {

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Väärin valittu kohde");
                        return;

                    }
                    Lutemon lutemon = (Lutemon) lutemons.get(kohde);
                    // annetaan lutemonille täydet hp:t
                    lutemon.setHealth(lutemon.getmaxHP());

                    break;
                }

            case 2:

                return;
        }
    }

    public void addItem(String key) {
        reppu.merge(key, 1, (a, b) -> a + b);
    }

    public void useItem(String key) {
        reppu.merge(key, 1, (a, b) -> a - b);

    }
}
