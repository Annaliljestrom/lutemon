package com.example.lutemongame;

import static androidx.core.content.ContextCompat.startActivity;

import static com.example.lutemongame.MainActivity.inventory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Battle.BattleFightActivity;
import com.example.lutemongame.Battle.ItemListActivity;

import java.util.ArrayList;

public class lutemonListAdapter extends RecyclerView.Adapter<lutemonViewHolder> {
    private Context context;

    public lutemonListAdapter() {

    }

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
        holder.lutemonColour.setText("Type = "+ lutemon.getColor());
        holder.lutemonAttack.setText("Attack = "+ lutemon.getAttack());
        holder.lutemonDefence.setText("Defence = " + lutemon.getDefence());
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getLevel());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
        holder.lutemonBattles.setText("Battles = "+lutemon.getBattles());
        holder.lutemonTrainingDays.setText("Training Days = "+lutemon.getTrainingDays());
        holder.lutemonVictories.setText("Victories = "+lutemon.getVictories());
        holder.lutemonDefeats.setText("Defeats = "+lutemon.getDefeats());
        holder.lutemonImage.setClickable(true);

        holder.lutemonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lutemon.setHealth(lutemon.getmaxHP());
                inventory.removeItem("");
                switchToItemListActivity(view);

            }
        });


    }

    @Override
    public int getItemCount() {
        return Inventory.getLutemons().size();
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
