package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FM0happy extends AppCompatActivity {

    String userName;
    TextView userInHappyTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm0_happy);

        Bundle extras = getIntent().getExtras();
        System.out.println("extras in moods: " + extras );
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        userInHappyTV = (TextView) findViewById(R.id.userInHappy);
        userInHappyTV.setText(userName);

        Button getlist0 = (Button) findViewById(R.id.list0);
        Button addlist0 = (Button) findViewById(R.id.addlist0);
        Button shareMood = (Button) findViewById(R.id.shareMood);

        getlist0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM0happy.this, FHappyActivityList.class);
                startActivity(intent);
            }
        });
        addlist0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM0happy.this, FUploadActivityHappy.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM0happy.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                System.out.println("userName on click: " + userName);
                intent.putExtra("user_name", userName);

                startActivity(intent);
            }
        });
    }
}