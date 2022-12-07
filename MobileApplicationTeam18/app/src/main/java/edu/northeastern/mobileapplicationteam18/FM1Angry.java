package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FM1Angry extends AppCompatActivity {

    String userName;
    TextView userInAngryTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm1_angry);

        Bundle extras = getIntent().getExtras();
        System.out.println("extras in moods in angry: " + extras );
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        userInAngryTV = (TextView) findViewById(R.id.userInAngry);
        userInAngryTV.setText(userName);


        Button getlist1 = (Button) findViewById(R.id.list1);
        Button addlist1 = (Button) findViewById(R.id.addlist1);
        Button shareMood = (Button) findViewById(R.id.shareMood);

        getlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM1Angry.this, FImage1.class);
                startActivity(intent);
            }
        });
        addlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM1Angry.this, FUpload1.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM1Angry.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });
    }
}