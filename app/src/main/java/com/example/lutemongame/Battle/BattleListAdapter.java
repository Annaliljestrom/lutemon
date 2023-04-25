package com.example.lutemongame.Battle;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.Inventory;
import com.example.lutemongame.Lutemon;
import com.example.lutemongame.R;

import java.util.ArrayList;

public class BattleListAdapter extends RecyclerView.Adapter<BattleViewHolder> {
    private Context context;

    public Context getContext() {
        return context;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    private ArrayList<Lutemon> lutemons ;

    public BattleListAdapter(Context applicationContext, ArrayList<Lutemon> lutemons) {
        this.context=applicationContext;
        this.lutemons=lutemons;
    }



    @NonNull
    @Override
    public BattleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BattleViewHolder(LayoutInflater.from(context).inflate(R.layout.battle_view_clickable,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull BattleViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);


        holder.lutemonName.setText(lutemon.getName());
        holder.lutemonColour.setText("Type = "+String.valueOf(lutemon.getColor()));
        holder.lutemonAttack.setText("Attack = "+String.valueOf(lutemon.getAttack()));
        holder.lutemonDefence.setText("Defence = " +String.valueOf(lutemon.getDefence()));
        holder.lutemonHealth.setText("Hp = "+lutemon.getHealth()+"/"+lutemon.getmaxHP());
        holder.lutemonLevel.setText("Level = "+lutemon.getTaso());
    }

    @Override
    public int getItemCount() {
        return Inventory.getLutemons().size();
    }

}

