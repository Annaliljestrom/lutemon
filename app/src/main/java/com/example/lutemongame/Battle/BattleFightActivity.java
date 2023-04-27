package com.example.lutemongame.Battle;

import static com.example.lutemongame.Inventory.getBattleLutemons;
import static com.example.lutemongame.Inventory.lutemons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lutemongame.Inventory;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.R;

public class BattleFightActivity extends AppCompatActivity {
    ImageView lutemon1Image,lutemon1ImageSmall, lutemon2Image, playerLutemonImage, ability1Image, ability2Image;
    TextView lutemon1Name,lutemon2Name, lutemon1Health, lutemon2Health;
    Button inventory;
    ProgressBar progressBar1, progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_view);
        Lutemon lutemon1 = getBattleLutemons().get(0);
        Lutemon lutemon2 = getBattleLutemons().get(1);
        playerLutemonImage = findViewById(R.id.playerLutemonImage);
        ability1Image = findViewById(R.id.ability1Image);
        ability2Image= findViewById(R.id.ability2Image);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        lutemon1Health = findViewById(R.id.txtHP);
        lutemon2Health = findViewById(R.id.txtHP2);
        inventory = findViewById(R.id.btnInventory);
        lutemon1Name = findViewById(R.id.txtLutemon1Name);
        lutemon2Name = findViewById(R.id.txtLutemon2Name);
        lutemon1ImageSmall = findViewById(R.id.imageLutemon1Small);
        lutemon1Image = findViewById(R.id.playerLutemonImage);
        lutemon2Image = findViewById(R.id.imageLutemon2);

        playerLutemonImage.setImageResource(lutemon1.getImage());
        ability1Image.setImageResource(R.drawable.poisonous_fart);
        ability2Image.setImageResource(R.drawable.awkward_stare);
        lutemon1Health.setText(lutemon1.getHealth()+"/"+lutemon1.getmaxHP());
        lutemon2Health.setText(lutemon2.getHealth()+"/"+lutemon2.getmaxHP());
        lutemon1Name.setText(lutemon1.getName());
        lutemon2Name.setText(lutemon2.getName());
        lutemon1Image.setImageResource(lutemon1.getImage());
        lutemon2Image.setImageResource(lutemon2.getImage());
        lutemon1ImageSmall.setImageResource(lutemon1.getImage());
        progressBar1.setProgress(100);
        progressBar2.setProgress(100);

    }


}