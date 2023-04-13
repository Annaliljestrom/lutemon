package com.example.lutemongame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lutemonListAdapter extends RecyclerView.Adapter<lutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons;

    public lutemonListAdapter(Context applicationContext, ArrayList<Lutemon> lutemons) {
        this.context=context;
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

        holder.lutemonName.setText(lutemons.get(position).getName());
        //holder.lutemonColour.setText(lutemons.get(position).getColor());
        holder.lutemonAttack.setText(lutemons.get(position).getAttack());
        holder.lutemonDefence.setText(lutemons.get(position).getDefence());
        holder.lutemonHealth.setText(lutemons.get(position).getHealth()+"/"+lutemons.get(position).getmaxHP());
        holder.lutemonLevel.setText(lutemons.get(position).getTaso());
        notifyDataSetChanged();





    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
