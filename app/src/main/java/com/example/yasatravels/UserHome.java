package com.example.yasatravels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class UserHome extends AppCompatActivity {

    private ImageButton profileButton;
    private ImageButton contactButton;
    private ImageButton aboutusButton;
    //private Button explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        //enable back button on action bar to navigate back to signup page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //switch to user profile by clicking profile icon
        profileButton = (ImageButton) findViewById(R.id.home_profileIcon);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfile();
            }
        });

        //switch to contact us page by clicking contact us icon
        contactButton = (ImageButton) findViewById(R.id.homeContactIcon);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContactUs();
            }
        });

        //switch to about us page by clicking about us icon
        aboutusButton = (ImageButton) findViewById(R.id.homeAboutusIcon);
        aboutusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutUs();
            }
        });
    }

    //switch to user profile by clicking profile icon
    public void openUserProfile() {
        Intent intent = new Intent(this,UserProfile.class);
        startActivity(intent);
    }

    //switch to contact us page by clicking contact us icon
    public  void openContactUs() {
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }

    //switch to about us page by clicking about us icon
    public void openAboutUs() {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
}