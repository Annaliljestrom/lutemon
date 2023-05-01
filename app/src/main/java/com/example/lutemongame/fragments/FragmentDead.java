package com.example.lutemongame.fragments;

import static com.example.lutemongame.Inventory.deadLutemons;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.DeadLutemonListAdapter;
import com.example.lutemongame.MainActivity;
import com.example.lutemongame.R;


public class FragmentDead extends Fragment {
    Button returnMainMenu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dead_lutemons, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        returnMainMenu = view.findViewById(R.id.btnReturnMainMenu);
        // Taking dead lutemons from the list and adding them to the recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.rvDeadLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DeadLutemonListAdapter adapter = new DeadLutemonListAdapter(getContext(), deadLutemons);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        returnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMainActivity(view);
            }
        });
    }
    public void switchToMainActivity(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}