package com.example.lutemongame.Training;

import static com.example.lutemongame.Inventory.lutemons;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.lutemongame.R;

public class TrainingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TrainingListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TrainingListAdapter(this, lutemons);
        recyclerView.setAdapter(adapter);

    }
    public static void GG(){
        System.out.println("ggpw");
    }

}
