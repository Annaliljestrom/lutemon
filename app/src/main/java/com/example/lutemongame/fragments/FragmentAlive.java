package com.example.lutemongame.fragments;

import static com.example.lutemongame.Inventory.lutemons;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lutemongame.MainActivity;
import com.example.lutemongame.R;
import com.example.lutemongame.lutemonListAdapter;


public class FragmentAlive extends Fragment {

    Button returnMainMenu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alive_lutemons, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Taking lutemons from the lutemon list and adding them to the recyclerview
        returnMainMenu = view.findViewById(R.id.btnReturnMainMenu);
        RecyclerView recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        lutemonListAdapter adapter = new lutemonListAdapter(getContext(), lutemons);
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