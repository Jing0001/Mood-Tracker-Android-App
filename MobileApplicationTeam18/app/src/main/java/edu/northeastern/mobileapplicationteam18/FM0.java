package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FM0 extends AppCompatActivity {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm0);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("user_name");
        }

        Button getlist0 = (Button) findViewById(R.id.list0);
        Button addlist0 = (Button) findViewById(R.id.addlist0);
        Button shareMood = (Button) findViewById(R.id.shareMood);

        getlist0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM0.this, FImage.class);
                startActivity(intent);
            }
        });
        addlist0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM0.this, FUpload.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM0.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });
    }
}