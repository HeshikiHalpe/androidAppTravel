package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity2 extends AppCompatActivity {

    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //enable back button on action bar to navigate back to signup page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //switch to user profile by clicking profile icon
        profileButton = (ImageButton) findViewById(R.id.homeProfileIcon);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfile();
            }
        });
    }

    public void openUserProfile() {
        Intent intent = new Intent(this,UserProfile.class);
        startActivity(intent);
    }
}