package com.example.familiarecipe;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class main_screens extends AppCompatActivity {
    Intent i;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screens);
        i = new Intent(this, not_registered.class);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new FeedFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.button_icon_feed:
                            fragment = new FeedFragment();
                            break;
                        case R.id.button_icon_search:
                            fragment = new SearchFragment();
                            break;
                        case R.id.button_icon_favorite:
                            fragment = new FavoritesFragment();
                            break;
                        case R.id.button_icon_account:
                            SharedPreferences sp = getPreferences(MODE_PRIVATE);
                            int a = sp.getInt("is_logged", 0);
                            if (a == 0) {
                                startActivity(i);
                            }
                            fragment = new AccountFragment();
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + item.getItemId());
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
                    return false;
                }
            };
}