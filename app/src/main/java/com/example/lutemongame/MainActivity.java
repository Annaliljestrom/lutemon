package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static Inventory inventory = Inventory.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        System.out.println("Welcome to Lutemonland!");
        /*
        System.out.println("1) New Game\n2) Load Game\n");
        Integer gameMode = Integer.parseInt(scan.nextLine());

        switch (gameMode) {
            case 1:
                menu(scan);
                break;
            case 2:
                //load game here
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }

         */
    }
/*
    public static void menu() {

        int i = 0;
        int x;

        do {

            System.out.println(
                    "1) Create new lutemon\n2) List lutemons\n3) Inventory\n4) Fight (ei tehty)\n5) Training area\n6) Save lutemons(ei täysin valmis)\n7) Show lutemon stats\n8) Campaign mode\n");
            //while(scan.hasNextLine()){
            Integer selection = Integer.parseInt(scan.nextLine());

            x = selection;
            Lutemon lutemon = new Lutemon();
            switch (selection) {
                case 1:
                    lutemon.createLutemon(lutemon, scan,i);
                    i++;
                    break;
                case 2:
                    System.out.println("Lutemons:\n");
                    Lutemon.listLutemons(Inventory.lutemons);
                    System.out.println("Dead lutemons:");
                    Lutemon.listLutemons(Inventory.deadlutemons);
                    break;
                case 3:
                    inventory.addItem("Potion");
                    inventory.addItem("Revive potion");
                    inventory.listItemList();
                    Integer selectedItemIndex = Integer.parseInt(scan.nextLine());
                    inventory.selectItem(selectedItemIndex);
                    break;
                case 5:
                    Lutemon.listLutemons(Inventory.lutemons);
                    if (!Inventory.lutemons.isEmpty()){
                        System.out.println("Valitse kehitettävä lutemon");
                        Integer valittuLutemon = Integer.parseInt(scan.nextLine());
                        try{
                            Lutemon trainedLutemon = (Lutemon) Inventory.lutemons.get(valittuLutemon);
                            System.out.println(trainedLutemon.getName() + " Valittu kehitykseen. Siirrytään arenalle...\n");
                            CombatArenas.trainingArena(trainedLutemon, scan);

                        }catch(java.lang.IndexOutOfBoundsException e){
                            System.out.println("Not valid number");

                        }

                        break;
                    }
                    else{
                        System.out.println("No lutemons alive. Revive or create one first.\n");
                    }

                case 6:
                    //SaveFileManager thigs here

                    break;
                case 7:
                    lutemon.printAllLutemonStats();

                    // lutemon.printStats();
                    break;
                case 8:
                    Campaign campaign = new Campaign();
                    campaign.startcampaign();

                default:
                    System.out.println("ei kelvollinen valinta");
                    break;


            }

        } while (x != 0);
        System.out.println("Kiitos ohjelman käytöstä.");
        scan.close();
    }
*/
}