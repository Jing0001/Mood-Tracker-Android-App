package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FM4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm4);

        Button getlist4 = (Button) findViewById(R.id.list4);
        Button addlist4 = (Button) findViewById(R.id.addlist4);
        getlist4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM4.this, FImage4.class);
                startActivity(intent);
            }
        });
        addlist4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM4.this, FUpload4.class);
                startActivity(intent);
            }
        });
    }
}