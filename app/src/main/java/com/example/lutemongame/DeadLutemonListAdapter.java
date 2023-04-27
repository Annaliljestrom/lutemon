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

public class DeadLutemonListAdapter extends RecyclerView.Adapter<lutemonViewHolder> {
    private Context context;

    public Context getContext() {
        return context;
    }

    public ArrayList<Lutemon> getDeadLutemons() {return deadLutemons;
    }

    private ArrayList<Lutemon> deadLutemons = new ArrayList<Lutemon>();

    public DeadLutemonListAdapter(Context applicationContext, ArrayList<Lutemon> deadlutemons) {
        this.context=applicationContext;
        this.deadLutemons=deadlutemons;
    }



    @NonNull
    @Override
    public lutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new lutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull lutemonViewHolder holder, int position) {
        Lutemon lutemon = deadLutemons.get(position);


        holder.lutemonName.setText(lutemon.getName());
        holder.lutemonColour.setText("Type = "+String.valueOf(lutemon.getColor()));
        holder.lutemonAttack.setText("Attack = "+String.valueOf(lutemon.getAttack()));
        holder.lutemonDefence.setText("Defence = " +String.valueOf(lutemon.getDefence()));
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getTaso());
        holder.lutemonImage.setImageResource(deadLutemons.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return deadLutemons.size();
    }
}
