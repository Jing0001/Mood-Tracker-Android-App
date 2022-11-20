package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class FMoods extends AppCompatActivity {
    GridLayout mainGrid;
    Integer count = 0;
    private TextView userNameTV;
//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmoods);

//        EditText username = (EditText) findViewById(R.id.username);
//        userNameTV = (TextView) findViewById(R.id.name);
//        final String nameTxt = username.getText().toString();
//        userNameTV.setText("Hello, " + nameTxt);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

//    private void setToggleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            final CardView cardView = (CardView) mainGrid.getChildAt(i);
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
//                        //Change background color
//                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
//                        Toast.makeText(FMoods.this, "State : True", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        //Change background color
//                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
//                        Toast.makeText(FMoods.this, "State : False", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            ArrayList<String> allMoods = new ArrayList<String>(Arrays.asList("Happy", "Sad", "Sleepy", "Angry", "Confused", "a",
                    "b", "c", "d", "e", "h", "i"));
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(FMoods.this,FM1.class);
                    intent.putExtra("info","Your Mood is  "+allMoods.get(finalI));


                    startActivity(intent);
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        count++;
        if (count == 2){
            super.onBackPressed();
        }else{
            Toast.makeText(getBaseContext(),"Click again to sign out", Toast.LENGTH_SHORT).show();
        }
    }

}