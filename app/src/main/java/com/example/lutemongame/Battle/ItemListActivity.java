package com.example.lutemongame.Battle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lutemongame.Inventory;
import com.example.lutemongame.R;

public class ItemListActivity extends AppCompatActivity {

    private Inventory inventory;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);

        inventory = Inventory.getInstance();
        recyclerView = findViewById(R.id.rvInventoryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), inventory.getItemList()));

        inventory.backpackContents();

    }
}