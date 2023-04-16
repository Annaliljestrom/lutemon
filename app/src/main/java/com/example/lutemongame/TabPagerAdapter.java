package com.example.lutemongame;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemongame.fragments.FragmentAlive;
import com.example.lutemongame.fragments.FragmentDead;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentAlive();
            case 1:
                return new FragmentDead();
            default:
                return  new FragmentAlive();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
