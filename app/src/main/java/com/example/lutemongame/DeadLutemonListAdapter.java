package com.example.lutemongame;

import static com.example.lutemongame.Inventory.deadLutemons;
import static com.example.lutemongame.Inventory.lutemons;
import static com.example.lutemongame.MainActivity.inventory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Battle.ItemListActivity;

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
        // Getting a lutemon from the dead lutemons list
        Lutemon lutemon = deadLutemons.get(position);
        // Setting lutemon's name, colour, attack, defence, health, level, image, battles,
        // training days, victories and defeats for the lutemon in the list view
        holder.lutemonName.setText(lutemon.getName());
        holder.lutemonColour.setText("Type = "+ lutemon.getColor());
        holder.lutemonAttack.setText("Attack = "+ lutemon.getAttack());
        holder.lutemonDefence.setText("Defence = " + lutemon.getDefence());
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getLevel());
        holder.lutemonImage.setImageResource(deadLutemons.get(position).getImage());
        holder.lutemonBattles.setText("Battles = "+lutemon.getBattles());
        holder.lutemonTrainingDays.setText("Training Days = "+lutemon.getTrainingDays());
        holder.lutemonVictories.setText("Victories = "+lutemon.getVictories());
        holder.lutemonDefeats.setText("Defeats = "+lutemon.getDefeats());
        holder.lutemonImage.setClickable(true);

        holder.lutemonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lutemon.setHealth(lutemon.getmaxHP());
                removeItem(holder.getAdapterPosition());
                deadLutemons.remove(lutemon);
                lutemons.add(lutemon);
                switchToItemListActivity(view);

            }
        });
    }

    @Override
    public int getItemCount() {
        // Tells the length of the dead lutemons list
        return deadLutemons.size();
    }
    public void switchToItemListActivity(View view) {
        Intent intent = new Intent(view.getContext(), ItemListActivity.class);
        view.getContext().startActivity(intent);

    }
    public void removeItem(int position) {
        inventory.getItemList().remove(position);
        notifyItemRemoved(position);
    }
}
