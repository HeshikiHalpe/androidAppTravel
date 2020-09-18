package com.example.yasatravels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserSignUp extends AppCompatActivity {

    private EditText regName, regAddress, regPhone, regEmail, regPassword, regPassword2;
    private Button signupButton;
    private TextView regToLogin;

    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference reference = rootNode.getReference("users").child("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        createUser();
    }

    private void createUser() {
        //hooks for all xml elements
        regName = findViewById(R.id.signupInputName);
        regAddress = findViewById(R.id.signupInputAddress);
        regPhone = findViewById(R.id.signupInputPhone);
        regEmail = findViewById(R.id.signupInputEmail);
        regPassword = findViewById(R.id.signupInputPassword);
        regPassword2 = findViewById(R.id.signupInputReenterPwd);
        regToLogin = findViewById(R.id.signup_loginLink);

        signupButton = (Button) findViewById(R.id.signUpButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserHome();

                //save data in firebase on button click
                //get all the values
                String name = regName.getText().toString().trim();
                String address = regAddress.getText().toString().trim();
                String phone = regPhone.getText().toString().trim();
                String email = regEmail.getText().toString().trim();
                String password = regPassword.getText().toString().trim();

                User use = new User(name, address, phone, email, password);
                reference.child(phone).setValue(use).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    public void openUserHome() {
        Intent intent = new Intent(this, UserHome.class);
        startActivity(intent);
    }
}