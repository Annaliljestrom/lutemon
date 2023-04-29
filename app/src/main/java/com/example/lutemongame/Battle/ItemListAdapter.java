package com.example.lutemongame.Battle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemongame.R;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private ArrayList<String> itemList  = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<String> itemList) {
        this.context = context;
        this.itemList = itemList;


    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.txtItemName.setText(itemList.get(position));
        if (itemList.get(position) == "Potion") {
            holder.itemImage.setImageResource(R.drawable.health_potion);
        } if (itemList.get(position) == "Revive potion") {
            holder.itemImage.setImageResource(R.drawable.revive_potion);
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
