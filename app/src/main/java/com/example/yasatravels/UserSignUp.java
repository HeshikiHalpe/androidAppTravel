package com.example.yasatravels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserSignUp extends AppCompatActivity {

    private EditText regName, regAddress, regPhone, regEmail, regPassword, regPassword2;
    private Button signupButton;
    private TextView regToLogin;
    private ProgressDialog dialog;

    private FirebaseAuth auth;
    private String userId;
    private FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    private DatabaseReference reference = rootNode.getReference().child("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        createUser();
    }

    private void createUser() {
        regName = findViewById(R.id.signupInputName);
        regAddress = findViewById(R.id.signupInputAddress);
        regPhone = findViewById(R.id.signupInputPhone);
        regEmail = findViewById(R.id.signupInputEmail);
        regPassword = findViewById(R.id.signupInputPassword);
        regPassword2 = findViewById(R.id.signupInputReenterPwd);
        regToLogin = findViewById(R.id.signup_loginLink);
        signupButton = findViewById(R.id.signUpButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = regName.getText().toString().trim();
                final String address = regAddress.getText().toString().trim();
                final String phone = regPhone.getText().toString().trim();
                final String email = regEmail.getText().toString().trim();
                final String password = regPassword.getText().toString().trim();
                String conformPassword = regPassword2.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    regName.setError("Name is Required");
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    regAddress.setError("Address is Required");
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    regPhone.setError("Phone number is Required");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    regPhone.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    regPhone.setError("Password is Required");
                    return;
                }
                if (TextUtils.isEmpty(conformPassword)) {
                    regPassword2.setError("Password is Required");
                    return;
                }
                if (!TextUtils.equals(password, conformPassword)) {
                    regPassword2.setError("Passwords are not matched");
                    return;
                }

                dialog.setMessage("Sending Data...");
                dialog.show();

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();
                            userId = auth.getCurrentUser().getUid();
                            User newUser = new User(name, address,phone,email,password);
                            reference.child(userId).setValue(newUser);
                        } else {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Registration Fail", Toast.LENGTH_SHORT).show();
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