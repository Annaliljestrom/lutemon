package com.example.lutemongame;

import android.content.Intent;
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
        // Getting the given lutemon's name
        name = editText.getText().toString();
        // Creating a new lutemon
        Lutemon lutemon = new Lutemon();
        // Getting the selected colour
        RadioGroup rgLutemonType = findViewById(R.id.colourCroup);
        Intent intent = new Intent(this, MainActivity.class);
        switch (rgLutemonType.getCheckedRadioButtonId()){
            // Setting the lutemons's colortype, name and id and returning to the main activity
            case R.id.whiteButton:
                lutemon.setColor(Lutemon.ColorType.WHITE);
                lutemon.createLutemon(lutemon,name,id);
                setContentView(R.layout.activity_main);
                startActivity(intent);
                break;
            case R.id.blackButton:
                lutemon.setColor(Lutemon.ColorType.BLACK);
                lutemon.createLutemon(lutemon,name,id);
                setContentView(R.layout.activity_main);
                startActivity(intent);
                break;
            case R.id.greenButton:
                lutemon.setColor(Lutemon.ColorType.GREEN);
                lutemon.createLutemon(lutemon,name,id);
                setContentView(R.layout.activity_main);
                startActivity(intent);
                break;
            case R.id.orangeButton:
                lutemon.setColor(Lutemon.ColorType.ORANGE);
                lutemon.createLutemon(lutemon,name,id);
                setContentView(R.layout.activity_main);
                startActivity(intent);
                break;
            case R.id.pinkButton:
                lutemon.setColor(Lutemon.ColorType.PINK);
                lutemon.createLutemon(lutemon,name,id);
                setContentView(R.layout.activity_main);
                startActivity(intent);
                break;
        }
    }
}
