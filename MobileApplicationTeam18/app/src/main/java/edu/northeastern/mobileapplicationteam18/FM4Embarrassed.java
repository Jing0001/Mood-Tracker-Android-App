package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FM4Embarrassed extends AppCompatActivity {

    String userName;
    TextView userInEmbarrassedTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm4_embarrased);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        userInEmbarrassedTV = (TextView) findViewById(R.id.userInEmbarrassed);
        userInEmbarrassedTV.setText(userName);
        Button shareMood = (Button) findViewById(R.id.shareMood);


        Button getlist4 = (Button) findViewById(R.id.list4);
        Button addlist4 = (Button) findViewById(R.id.addlist4);
        getlist4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM4Embarrassed.this, FImage4.class);
                startActivity(intent);
            }
        });
        addlist4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM4Embarrassed.this, FUpload4.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM4Embarrassed.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

    }
}