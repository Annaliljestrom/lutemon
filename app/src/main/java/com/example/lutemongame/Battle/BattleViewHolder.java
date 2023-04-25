package com.example.lutemongame.Battle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.R;

public class BattleViewHolder extends RecyclerView.ViewHolder {
    ImageView lutemonImage;
    TextView lutemonName, lutemonColour,lutemonAttack,lutemonDefence,lutemonHealth,lutemonLevel;


    public BattleViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage= itemView.findViewById(R.id.lutemonImage);
        lutemonName = itemView.findViewById(R.id.txtLutemonName);
        lutemonColour = itemView.findViewById(R.id.txtLutemonColour);
        lutemonAttack = itemView.findViewById(R.id.txtLutemonAttack);
        lutemonDefence = itemView.findViewById(R.id.txtLutemonDefence);
        lutemonHealth = itemView.findViewById(R.id.txtLutemonHealth);
        lutemonLevel = itemView.findViewById(R.id.txtLutemonLevel);
    }
}
