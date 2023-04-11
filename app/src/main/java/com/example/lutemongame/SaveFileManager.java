package com.example.lutemongame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFileManager {
    public static void tallennaTiedostoon(ArrayList<Object> lutemons, Lutemon lutemon) {
        try {
            FileWriter writer = new FileWriter("lutemons.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Object l : lutemons) {
                bufferedWriter.write(((Lutemon) l).getName() + ((Lutemon) l).getAttack());
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
