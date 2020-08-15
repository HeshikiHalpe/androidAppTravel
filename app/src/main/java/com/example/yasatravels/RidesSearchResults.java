package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RidesSearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides_search_results);

        //enable back button on action bar to navigate back to search window
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void viewDetailsHandler(View view) {
        ImageView Rideimage = findViewById(R.id.imageView1);
        Intent intent = new Intent(this, RidesDetails.class);
        // to pass image transition between activity nevigation
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,Rideimage, ViewCompat.getTransitionName(Rideimage));
        startActivity(intent,options.toBundle());
    }
}