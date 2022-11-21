package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.northeastern.mobileapplicationteam18.MainActivity;
import edu.northeastern.mobileapplicationteam18.R;

public class FM1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm1);

        Button getlist1 = (Button) findViewById(R.id.list1);
        getlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FM1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}