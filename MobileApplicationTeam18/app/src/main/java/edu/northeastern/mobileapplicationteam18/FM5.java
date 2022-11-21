package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FM5 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm5);

        Button getlist5 = (Button) findViewById(R.id.list5);
        getlist5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM5.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}