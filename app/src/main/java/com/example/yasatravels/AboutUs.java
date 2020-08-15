package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //enable back button on action bar to navigate back to signup page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}