package com.app.countriesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.bottom_navigatin_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about_us, R.id.nav_profile,R.id.nav_america, R.id.nav_switzerland, R.id.nav_iran)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

//        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
//            int id = destination.getId();
//
//            switch (id){
//                case R.id.nav_america:
//                    Toast.makeText(MainActivity.this,"AMERICA",Toast.LENGTH_LONG).show();
//                    break;
//                case R.id.nav_switzerland:
//                    Toast.makeText(MainActivity.this,"SWITZERLAND",Toast.LENGTH_LONG).show();
//                    break;
//                case R.id.nav_iran:
//                    Toast.makeText(MainActivity.this,"IRAN",Toast.LENGTH_LONG).show();
//                    break;
//            }
//        });
    }
}