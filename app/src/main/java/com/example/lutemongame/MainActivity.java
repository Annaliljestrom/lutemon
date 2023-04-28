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

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            switch (view.getId()) {

                case R.id.listLutemonsButton:
                    Intent intent = new Intent(view.getContext(), TabActivity.class);
                    startActivity(intent);
                    return;

                default:
                    fragment = new FragmentAlive();
                    break;
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
}
