package com.example.lutemongame.Battle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView itemImage;
    TextView txtItemName;
    TextView txtItemNumber;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.itemImage);

        txtItemName = itemView.findViewById(R.id.txtItemName);
        txtItemNumber = itemView.findViewById(R.id.txtItemNumber);


    }
}
