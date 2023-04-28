package com.example.lutemongame;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lutemonListAdapter extends RecyclerView.Adapter<lutemonViewHolder> {
    private Context context;

    public Context getContext() {
        return context;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    private ArrayList<Lutemon> lutemons ;

    public lutemonListAdapter(Context applicationContext, ArrayList<Lutemon> lutemons) {
        this.context=applicationContext;
        this.lutemons=lutemons;
    }



    @NonNull
    @Override
    public lutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new lutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull lutemonViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.lutemonName.setText(lutemon.getName());
        holder.lutemonColour.setText("Type = "+String.valueOf(lutemon.getColor()));
        holder.lutemonAttack.setText("Attack = "+String.valueOf(lutemon.getAttack()));
        holder.lutemonDefence.setText("Defence = " +String.valueOf(lutemon.getDefence()));
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getTaso());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
        holder.lutemonBattles.setText("Battles = "+lutemon.getBattles());
        holder.lutemonTrainingDays.setText("Training Days = "+lutemon.getTrainingDays());
        holder.lutemonVictories.setText("Victories = "+lutemon.getVictories());
        holder.lutemonDefeats.setText("Defeats = "+lutemon.getDefeats());


    }

    @Override
    public int getItemCount() {
        return Inventory.getLutemons().size();
    }
}
