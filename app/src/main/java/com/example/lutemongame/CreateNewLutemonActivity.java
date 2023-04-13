package com.example.lutemongame;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNewLutemonActivity extends AppCompatActivity {

    private int id=0;
    private EditText editText;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_lutemon);
        editText = findViewById(R.id.lutemonNameInput);



    }

    public void createLutemonType(View view){
        name = editText.getText().toString();
        Lutemon lutemon = new Lutemon();
        System.out.println("Nimi on ----------------------"+name);
        RadioGroup rgLutemonType = findViewById(R.id.colourCroup);

        switch (rgLutemonType.getCheckedRadioButtonId()){
            case R.id.whiteButton:
                lutemon.setColor(Lutemon.ColorType.WHITE);
                lutemon.createLutemon(lutemon,name,id);
                //System.out.println("valkonen lutemon luotu");
                Inventory.getLutemons().add(lutemon);
                setContentView(R.layout.activity_main);
                System.out.println(lutemon.getName()+lutemon.getColor());
                break;
            case R.id.blackButton:
                lutemon.setColor(Lutemon.ColorType.BLACK);
                setContentView(R.layout.activity_main);

                break;
            case R.id.greenButton:
                lutemon.setColor(Lutemon.ColorType.GREEN);
                setContentView(R.layout.activity_main);
                break;
            case R.id.orangeButton:
                lutemon.setColor(Lutemon.ColorType.ORANGE);
                setContentView(R.layout.activity_main);
                break;
            case R.id.pinkButton:
                lutemon.setColor(Lutemon.ColorType.PINK);
                setContentView(R.layout.activity_main);
                break;
        }
    }
}
