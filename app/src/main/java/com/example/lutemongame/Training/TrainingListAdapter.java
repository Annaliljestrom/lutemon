package com.example.lutemongame.Training;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Inventory;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.R;

import java.util.ArrayList;

public class TrainingListAdapter extends RecyclerView.Adapter<TrainingViewHolder> {
    private Context context;

    public Context getContext() {
        return context;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    private ArrayList<Lutemon> lutemons ;
    Lutemon lutemon1;
    private int i=1;


    public TrainingListAdapter(Context applicationContext, ArrayList<Lutemon> lutemons) {
        this.context=applicationContext;
        this.lutemons=lutemons;
    }



    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingViewHolder(LayoutInflater.from(context).inflate(R.layout.battle_view_clickable,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.lutemonName.setText(lutemon.getName());
        holder.lutemonColour.setText("Type = "+String.valueOf(lutemon.getColor()));
        holder.lutemonAttack.setText("Attack = "+String.valueOf(lutemon.getAttack()));
        holder.lutemonDefence.setText("Defence = " +String.valueOf(lutemon.getDefence()));
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getTaso());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());


        holder.selectedLutemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lutemon1 = lutemons.get(holder.getAdapterPosition());
                TrainingActivity.GG();
            };


        });

    }



    @Override
    public int getItemCount() {
        return Inventory.getLutemons().size();
    }

}


