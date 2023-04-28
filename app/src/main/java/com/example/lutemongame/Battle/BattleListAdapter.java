package com.example.lutemongame.Battle;

import static android.app.PendingIntent.getActivity;

import static com.example.lutemongame.Inventory.battleLutemons;
import static com.example.lutemongame.Inventory.lutemons;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
    Lutemon lutemon1;


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
        holder.lutemonLevel.setText("Level = "+lutemon.getLevel());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());


        holder.selectedLutemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Lutemon lutemon1 = lutemons.get(holder.getAdapterPosition());
                if (battleLutemons.size() >= 1){
                    battleLutemons.set(0,lutemon1);
                }else {
                    battleLutemons.add(0, lutemon1);
                    System.out.println("Lutemon 1 valittu:" + lutemon1.getName());
                    BattleTabActivity1.setFragmentTab1(1);
                }
            };


        });

    }

    @Override
    public int getItemCount() {
        return Inventory.getLutemons().size();
    }

}

