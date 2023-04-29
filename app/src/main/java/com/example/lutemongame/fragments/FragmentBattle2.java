package com.example.lutemongame.fragments;

import static androidx.core.content.ContextCompat.startActivity;
import static com.example.lutemongame.Inventory.battleLutemons;
import static com.example.lutemongame.Inventory.lutemons;

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

import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.Battle.BattleListAdapter;
import com.example.lutemongame.Battle.BattleListAdapter2;
import com.example.lutemongame.Battle.BattleViewHolder;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.R;

public class FragmentBattle2 extends Fragment {
    private RecyclerView recyclerView;
    private BattleListAdapter2 adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_battle2, container, false);
        Button btnFight= view.findViewById(R.id.btnFight);

        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // listening if fight-button is clicked
                btnFight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchToBattleFightActivity(view);
                    }
                });
            }
        });
        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // taking lutemons from the lutemonList and adding them to the recyclerview
        recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BattleListAdapter2(getContext(), lutemons);
        recyclerView.setAdapter(adapter);
    }

    public void switchToBattleFightActivity(View view) {
        // switching to the view where the battle is going to start
        Intent intent = new Intent(view.getContext(), BattleFightActivity.class);
        view.getContext().startActivity(intent);
    }

}
