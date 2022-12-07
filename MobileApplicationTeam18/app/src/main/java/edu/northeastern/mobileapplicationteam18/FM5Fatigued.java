package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FM5Fatigued extends AppCompatActivity {

    String userName;
    TextView userInFatiguedTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm5_fatigued);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        userInFatiguedTV = (TextView) findViewById(R.id.userInFatigued);
        userInFatiguedTV.setText(userName);
        Button shareMood = (Button) findViewById(R.id.shareMood);

        Button getlist5 = (Button) findViewById(R.id.list5);
        Button addlist5 = (Button) findViewById(R.id.addlist5);
        getlist5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM5Fatigued.this, FImage5.class);
                startActivity(intent);
            }
        });
        addlist5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM5Fatigued.this, FUpload5.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM5Fatigued.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });
    }
}