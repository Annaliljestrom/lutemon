package com.example.lutemongame.Battle;

import static com.example.lutemongame.Inventory.battleLutemons;
import static com.example.lutemongame.Inventory.getBattleLutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lutemongame.CombatArenas;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.MainActivity;
import com.example.lutemongame.R;

public class BattleFightActivity extends AppCompatActivity {
    ImageView lutemon1Image,lutemon1ImageSmall, lutemon2Image, playerLutemonImage, ability1Image, ability2Image;
    TextView lutemon1Name,lutemon2Name, lutemon1Health, lutemon2Health;
    public static TextView txtWinner,txtLvlUp;
    Button inventory, btnReturn;
    ProgressBar progressBar1, progressBar2;
    private Float percentageHP;
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
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setVisibility(View.GONE);
        txtWinner = findViewById(R.id.txtWinner);
        txtWinner.setVisibility(View.GONE);
        txtLvlUp = findViewById(R.id.txtLvlUp);
        txtLvlUp.setVisibility(View.GONE);


        resetView(lutemon1,lutemon2);

        ability1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculating proggressbar status and health text
                Boolean FightOver = CombatArenas.trainingArena(0);
                lutemon1Health.setText(lutemon1.getHealth()+"/"+lutemon1.getmaxHP());
                lutemon2Health.setText(lutemon2.getHealth()+"/"+lutemon2.getmaxHP());
                progressBar1.setProgress(progressBarChange(lutemon1.getHealth(),lutemon1.getmaxHP()));
                progressBar2.setProgress(progressBarChange(lutemon2.getHealth(),lutemon2.getmaxHP()));

                if (FightOver==true){
                    btnReturn.setVisibility(View.VISIBLE);
                    txtWinner.setVisibility(View.VISIBLE);
                    ability1Image.setClickable(false);
                    ability2Image.setClickable(false);
                    lutemon1.setBattles(+1);
                    lutemon2.setBattles(+1);


                }
            }
        });
        ability2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculating proggressbar status and health text
                Boolean FightOver = CombatArenas.trainingArena(1);
                lutemon1Health.setText(lutemon1.getHealth()+"/"+lutemon1.getmaxHP());
                lutemon2Health.setText(lutemon2.getHealth()+"/"+lutemon2.getmaxHP());
                progressBar1.setProgress(progressBarChange(lutemon1.getHealth(),lutemon1.getmaxHP()));
                progressBar2.setProgress(progressBarChange(lutemon2.getHealth(),lutemon2.getmaxHP()));

                if (FightOver==true){
                    btnReturn.setVisibility(View.VISIBLE);
                    ability1Image.setClickable(false);
                    ability2Image.setClickable(false);
                    inventory.setClickable(false);
                    lutemon1.setBattles(+1);
                    lutemon2.setBattles(+1);



                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetView(lutemon1,lutemon2);
                Intent intent = new Intent(BattleFightActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            });


    }

    public int progressBarChange( int hp, int maxhp){

        Float percentageHP = ((float)hp/(float)maxhp) *100;
    return Math.round(percentageHP);
    }
    public void resetView(Lutemon lutemon1, Lutemon lutemon2){

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
        txtWinner.setText("Winner is");
    }
    public static void setWinner(String winner){
        txtWinner.setText("Winner is "+winner+"!");
    }
    public static void levelUp(int oldLevel, int newLevel, String lutemonName){
        if (oldLevel!=newLevel){
            txtLvlUp.setVisibility(View.VISIBLE);
            txtLvlUp.setText(lutemonName+" Level has increased!\n"+lutemonName+" is now level "+newLevel);
        }
    }
}