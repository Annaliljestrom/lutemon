package com.example.lutemongame;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNewLutemonActivity extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = String.valueOf(findViewById(R.id.lutemonNameInput));
        setContentView(R.layout.activity_create_new_lutemon);


    }

    public void createLutemonType(View view){


        Lutemon lutemon = new Lutemon();
        lutemon.setName(name);
        RadioGroup rgLutemonType = findViewById(R.id.colourCroup);

        switch (rgLutemonType.getCheckedRadioButtonId()){
            case R.id.whiteButton:
                lutemon.setColor(Lutemon.ColorType.WHITE);
                //System.out.println("valkonen lutemon luotu");
                Inventory.getLutemons().add(lutemon);
                //System.out.println(Inventory.getLutemons());
                break;
            case R.id.blackButton:
                lutemon.setColor(Lutemon.ColorType.BLACK);

                break;
            case R.id.greenButton:
                lutemon.setColor(Lutemon.ColorType.GREEN);
                break;
            case R.id.orangeButton:
                lutemon.setColor(Lutemon.ColorType.ORANGE);
                break;
            case R.id.pinkButton:
                lutemon.setColor(Lutemon.ColorType.PINK);
                break;
        }
    }
}
