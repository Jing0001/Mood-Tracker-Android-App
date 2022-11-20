package edu.northeastern.mobileapplicationteam18;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FLogin extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flogin1);

        EditText username = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        EditText repassword = (EditText) findViewById(R.id.repassword);
        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameTxt = username.getText().toString();
//                String emailTxt = email.getText().toString();
                final String passwordTxt = password.getText().toString();
                if(nameTxt.isEmpty() || passwordTxt.isEmpty()){
                    // Incorrect
                    Toast.makeText(FLogin.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child(("FUser")).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if email is exist in firebase database
                            if (snapshot.hasChild(nameTxt)){
                                // email exits
                                final String getPassword = snapshot.child(nameTxt).child("password").getValue(String.class);
                                if (getPassword.equals(passwordTxt)){
                                    Toast.makeText(FLogin.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(FLogin.this, MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(FLogin.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(FLogin.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
        }});

//        regbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // open Register activity
//                startActivity(new Intent(FLogin.this, FSignup.class));
//            }
//        });


    }
}