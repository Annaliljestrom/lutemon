package com.example.lutemongame.Battle;

import static com.example.lutemongame.MainActivity.inventory;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.CreateNewLutemonActivity;
import com.example.lutemongame.Inventory;
import com.example.lutemongame.R;
import com.example.lutemongame.TabActivity;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView itemImage;
    TextView txtItemName;
    TextView txtItemNumber;
    ItemListAdapter adapter;
    public ItemViewHolder(@NonNull View itemView, ItemListAdapter adapter) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.itemImage);

        txtItemName = itemView.findViewById(R.id.txtItemName);
        txtItemNumber = itemView.findViewById(R.id.txtItemNumber);
        itemImage.setClickable(true);
        this.adapter = adapter;


        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToTabActivity(itemView.getContext(), getAdapterPosition());


            }
        });


    }
    public void switchToTabActivity(Context context, int position) {
        inventory.removeItem(inventory.getItemList().get(position));
        adapter.removeItem(position);
        Intent intent = new Intent(context, TabActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
