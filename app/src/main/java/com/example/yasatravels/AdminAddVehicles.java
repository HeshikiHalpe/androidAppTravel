package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdminAddVehicles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_vehicles);

        //enable back button on action bar to navigate back to manage rides admin page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}