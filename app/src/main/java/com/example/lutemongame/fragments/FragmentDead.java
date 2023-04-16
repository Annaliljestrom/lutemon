package com.example.lutemongame.fragments;

import static com.example.lutemongame.Inventory.deadlutemons;
import static com.example.lutemongame.Inventory.lutemons;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lutemongame.Inventory;
import com.example.lutemongame.R;
import com.example.lutemongame.DeadLutemonListAdapter;


public class FragmentDead extends Fragment {
    private RecyclerView recyclerView;
    private DeadLutemonListAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dead_lutemons, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvDeadLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DeadLutemonListAdapter(getContext(), deadlutemons);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}