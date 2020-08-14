package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdminUpdateVehicles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_vehicles);

        //enable back button on action bar to navigate back to manage vehicles admin page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}