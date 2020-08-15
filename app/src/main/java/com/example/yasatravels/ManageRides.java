package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ManageRides extends AppCompatActivity {

    private Button addVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_rides);

        //enable back button on action bar to navigate back to admin dashboard
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //add new vehicle
        addVehicle = (Button) findViewById(R.id.button03);
        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddNewVehicle();
            }
        });
    }

    //add new vehicle
    public void openAddNewVehicle() {
        Intent intent = new Intent(this, AdminAddVehicles.class);
        startActivity(intent);
    }

    //open view ride
    public void viewDetailsHandler(View view) {
        ImageView Rideimage = findViewById(R.id.imageView9);
        Intent intent = new Intent(this, ViewRide.class);
        // to pass image transition between activity nevigation
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,Rideimage, ViewCompat.getTransitionName(Rideimage));
        startActivity(intent,options.toBundle());
    }
}