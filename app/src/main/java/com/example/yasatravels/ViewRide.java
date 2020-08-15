package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;

public class ViewRide extends AppCompatActivity {

    private Button updateVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ride);

        //enable back button on action bar to navigate back to manage rides admin page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //to make a smooth activity window open
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        //Open Update vehicle details
        updateVehicle = (Button) findViewById(R.id.button9);
        updateVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUpdateVehicle();
            }
        });
    }

    //Open Update vehicle details
    public void openUpdateVehicle() {
        Intent intent = new Intent(this, AdminUpdateVehicles.class);
        startActivity(intent);
    }
}