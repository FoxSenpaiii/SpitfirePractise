package com.example.familiarecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class  articles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener((OnNavigationItemSelectedListener) navListener);
    }

    private BottomNavigationView.OnNavigationItemReselectedListener navListener =  new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.button_icon_feed:
                    selectedFragment = new Fragment_feed();
                    break;
                case R.id.button_icon_search:
                    selectedFragment = new Fragment_search();
                    break;
                case R.id.button_icon_favorite:
                    selectedFragment = new Fragment_favorites();
                    break;
                case R.id.button_icon_account:
                    selectedFragment = new Fragment_account();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, selectedFragment).commit();
        }
    };
}