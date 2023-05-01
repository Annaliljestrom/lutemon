package com.example.lutemongame.Training;


import static com.example.lutemongame.Inventory.battleLutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Inventory;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.R;

import java.util.ArrayList;

public class TrainingListAdapter extends RecyclerView.Adapter<TrainingViewHolder> {
    private Context context;

    public TrainingListAdapter() {

    }

    public Context getContext() {
        return context;
    }
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
    private ArrayList<Lutemon> lutemons ;
    Lutemon lutemon1;

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
        // Taking a lutemon from the list
        Lutemon lutemon = lutemons.get(position);
        // Setting the lutemon's stats to the list in training
        holder.lutemonName.setText(lutemon.getName());
        holder.lutemonColour.setText("Type = "+ lutemon.getColor());
        holder.lutemonAttack.setText("Attack = "+ lutemon.getAttack());
        holder.lutemonDefence.setText("Defence = " + lutemon.getDefence());
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getLevel());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());

        holder.selectedLutemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Choosing which lutemon is going to be trained
                lutemon1 = lutemons.get(holder.getAdapterPosition());
                battleLutemons.set(0,lutemon1);
            }
        });

    }

    @Override
    public int getItemCount() {
        // the method tells lutemon list's length
        return Inventory.getLutemons().size();
    }

}


