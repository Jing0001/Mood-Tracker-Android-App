package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FM2Sad extends AppCompatActivity {
    String userName;
    TextView userInSadTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm2_sad);

        Bundle extras = getIntent().getExtras();
        System.out.println("extras in moods in sad: " + extras );
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        userInSadTV = (TextView) findViewById(R.id.userInSad);
        userInSadTV.setText(userName);
        Button shareMood = (Button) findViewById(R.id.shareMood);

        Button getlist2 = (Button) findViewById(R.id.list2);
        Button addlist2 = (Button) findViewById(R.id.addlist2);
        getlist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM2Sad.this, FImage2.class);
                startActivity(intent);
            }
        });
        addlist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM2Sad.this, FUpload2.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM2Sad.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });
    }
}