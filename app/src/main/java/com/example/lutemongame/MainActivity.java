package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.Battle.BattleTabActivity1;
import com.example.lutemongame.Training.TrainingActivity;
import com.example.lutemongame.fragments.FragmentAlive;

public class MainActivity extends AppCompatActivity {
    public static Inventory inventory = Inventory.getInstance();
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inventory.getInstance();
        Button fragmentTAB = findViewById(R.id.listLutemonsButton);
        fragmentTAB.setOnClickListener(listener);
        context = this;

        inventory.addItem2("Potion");
        inventory.addItem2("Revive potion");

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.listLutemonsButton) {
                Intent intent = new Intent(view.getContext(), TabActivity.class);
                startActivity(intent);
                return;
            }
        }
    };


    public void switchToCreateNewLutemon(View view) {
        Intent intent = new Intent(this, CreateNewLutemonActivity.class);
        startActivity(intent);
    }
    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void switchToTrainLutemon(View view) {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }
    public void switchToBattleFightActivity(View view) {
        Intent intent = new Intent(this, BattleFightActivity.class);
        startActivity(intent);
    }
    public void switchToBattleActivity(View view) {

        Intent intent = new Intent(this, BattleTabActivity1.class);
        startActivity(intent);
    }

    public void switchToSaveLutemons(View view) {
        Inventory.getInstance().saveLutemons(context);
    }

    public void switchToLoadLutemons(View view) {
        Inventory.getInstance().loadLutemons(context);
    }
    public static void resetDummy(){
        Lutemon dummy1 = new Lutemon();
        dummy1.chosenColorNumber(6);
        dummy1.lutemon(dummy1.getColor(), "Dummy", 0);
        dummy1.image = R.drawable.dummy_transparent;

        Lutemon dummy2 = new Lutemon();
        dummy2.chosenColorNumber(6);
        dummy2.lutemon(dummy2.getColor(), "Dummy", 0);
        dummy2.image = R.drawable.dummy_transparent;

        Inventory.battleLutemons.add(0,dummy1);
        Inventory.battleLutemons.add(1,dummy2);
    }
}
