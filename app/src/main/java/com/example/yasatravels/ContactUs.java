package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //enable back button on action bar to navigate back to home page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}