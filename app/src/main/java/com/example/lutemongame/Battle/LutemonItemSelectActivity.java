package com.example.lutemongame.Battle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lutemongame.R;
import com.example.lutemongame.lutemonListAdapter;


public class LutemonItemSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);
        RecyclerView recyclerView = findViewById(R.id.rvLutemonList);
        lutemonListAdapter adapter = new lutemonListAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
