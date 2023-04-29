package com.example.lutemongame.Battle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.lutemongame.R;
import com.google.android.material.tabs.TabLayout;

public class BattleTabActivity1 extends AppCompatActivity {
    public static ViewPager2 fragmentArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_choose_lutemons);
        TabLayout tabLayout = findViewById(R.id.TabArea);
        fragmentArea =  findViewById(R.id.fragmentArea);
        TabPagerAdapterBattle tabPagerAdapterBattle = new TabPagerAdapterBattle(this);
        fragmentArea.setAdapter(tabPagerAdapterBattle);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();

            }
        });

    }


    public static void setFragmentTab1(int j) {
        fragmentArea.setCurrentItem(j);
    }


}