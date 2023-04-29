package com.example.lutemongame.fragments;

import static com.example.lutemongame.Inventory.lutemons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Battle.BattleListAdapter;
import com.example.lutemongame.R;

public class FragmentBattle1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_battle1, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Taking lutemons from the lutemonList and adding them to the recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BattleListAdapter adapter = new BattleListAdapter(getContext(), lutemons);
        recyclerView.setAdapter(adapter);
    }
}
