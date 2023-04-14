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
        name = editText.getText().toString();
        Lutemon lutemon = new Lutemon();
        RadioGroup rgLutemonType = findViewById(R.id.colourCroup);
        Intent intent = new Intent(this, MainActivity.class);

        switch (rgLutemonType.getCheckedRadioButtonId()){
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
