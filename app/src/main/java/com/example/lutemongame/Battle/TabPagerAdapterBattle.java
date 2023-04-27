package com.example.lutemongame.Battle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemongame.fragments.FragmentBattle1;
import com.example.lutemongame.fragments.FragmentBattle2;

public class TabPagerAdapterBattle extends FragmentStateAdapter {
    public TabPagerAdapterBattle(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentBattle1();
            case 1:
                return new FragmentBattle2();

            default: return new FragmentBattle1();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
