package com.app.countriesapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;

import com.app.countriesapp.R;
import com.app.countriesapp.ui.fragments.MapsFragment;


public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Initialize fragment
        Fragment fragment = new MapsFragment();

        //Open fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();


    }
}