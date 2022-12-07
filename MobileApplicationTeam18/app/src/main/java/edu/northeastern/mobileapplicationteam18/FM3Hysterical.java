package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FM3Hysterical extends AppCompatActivity {

    String userName;
    TextView userInHystericalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm3_hysterical);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        userInHystericalTV = (TextView) findViewById(R.id.userInHysterical);
        userInHystericalTV.setText(userName);
        Button shareMood = (Button) findViewById(R.id.shareMood);


        Button getlist3 = (Button) findViewById(R.id.list3);
        Button addlist3 = (Button) findViewById(R.id.addlist3);
        getlist3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM3Hysterical.this, FImage3.class);
                startActivity(intent);
            }
        });
        addlist3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM3Hysterical.this, FUpload3.class);
                startActivity(intent);
            }
        });

        shareMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM3Hysterical.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });
    }
}