package com.example.travend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class tabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);

        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new MapsFragment()).commit();
    }

        private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.mapsFragment:
                        selectedFragment = new MapsFragment();
                        break;
                    case R.id.inviteFragment:
                        selectedFragment = new InviteFragment();
                        break;
                    case R.id.connectionFragment:
                        selectedFragment = new ConnectionFragment();
                        break;
                    case R.id.notificationFragment:
                        selectedFragment = new NotificationFragment();
                        break;
                    case R.id.profileFragment:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,selectedFragment).commit();
                return true;
            }
        };




}