package com.example.lutemongame.fragments;

import static com.example.lutemongame.Inventory.lutemons;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lutemongame.R;
import com.example.lutemongame.lutemonListAdapter;


public class FragmentAlive extends Fragment {
    private RecyclerView recyclerView;
    private lutemonListAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alive_lutemons, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new lutemonListAdapter(getContext(), lutemons);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}