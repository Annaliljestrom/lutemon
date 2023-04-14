package com.example.lutemongame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lutemonListAdapter extends RecyclerView.Adapter<lutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();

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
        int pos= holder.getAdapterPosition();


        holder.lutemonName.setText(Inventory.getLutemons().get(pos).getName());
        holder.lutemonColour.setText("Type = "+String.valueOf(Inventory.getLutemons().get(pos).getColor()));
        holder.lutemonAttack.setText("Attack = "+String.valueOf(Inventory.getLutemons().get(pos).getAttack()));
        holder.lutemonDefence.setText("Defence = " +String.valueOf(Inventory.getLutemons().get(pos).getDefence()));
        holder.lutemonHealth.setText("Hp = "+Inventory.getLutemons().get(pos).getHealth()+"/"+Inventory.getLutemons().get(pos).getmaxHP());
        holder.lutemonLevel.setText("Level = "+Inventory.getLutemons().get(pos).getTaso());
    }

    @Override
    public int getItemCount() {
        return Inventory.getLutemons().size();
    }
}
