package com.example.lutemongame.Training;

import static com.example.lutemongame.Inventory.lutemons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.MainActivity;
import com.example.lutemongame.R;

public class TrainingActivity extends AppCompatActivity {
    Button btnFight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        // Taking lutemons from the list and adding them to the recyclerview
        RecyclerView recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TrainingListAdapter adapter = new TrainingListAdapter(this, lutemons);
        recyclerView.setAdapter(adapter);
        btnFight = findViewById(R.id.btnFight);
        // Dummy is reseted for training
        MainActivity.resetDummy();

        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Switching to the training view
                    //battleLutemons.set(dummy,1);
                    Intent intent = new Intent(TrainingActivity.this, BattleFightActivity.class);
                    startActivity(intent);
            }
        });
    }

}
