package com.example.lutemongame.Training;

import static com.example.lutemongame.Inventory.battleLutemons;
import static com.example.lutemongame.Inventory.lutemons;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.Battle.BattleTabActivity1;
import com.example.lutemongame.CombatArenas;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.MainActivity;
import com.example.lutemongame.R;

public class TrainingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TrainingListAdapter adapter;
    Button btnFight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        // taking lutemons from the list and adding them to the recyclerview
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TrainingListAdapter(this, lutemons);
        recyclerView.setAdapter(adapter);
        btnFight = findViewById(R.id.btnFight);
        // Dummy is reseted for training
        MainActivity.resetDummy();

        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // switching to the training view
                    //battleLutemons.set(dummy,1);
                    Intent intent = new Intent(TrainingActivity.this, BattleFightActivity.class);
                    startActivity(intent);
            }
        });
    }

}
