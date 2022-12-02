package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    String userName;
//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmoods);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        Button calendar = (Button) findViewById(R.id.calendar);
        Button memory = (Button) findViewById(R.id.memory);
        Button send = (Button) findViewById(R.id.fSend);
        CardView cardView0 = (CardView) mainGrid.getChildAt(0);
        CardView cardView1 = (CardView) mainGrid.getChildAt(1);
        CardView cardView2 = (CardView) mainGrid.getChildAt(2);
        CardView cardView3 = (CardView) mainGrid.getChildAt(3);
        CardView cardView4 = (CardView) mainGrid.getChildAt(4);
        CardView cardView5 = (CardView) mainGrid.getChildAt(5);
        CardView cardView6 = (CardView) mainGrid.getChildAt(6);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FCalendar.class);
                startActivity(intent);
            }
        });

        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FMemory.class);
                startActivity(intent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FSendEmoji.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        // 0
        cardView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FM0.class);
                startActivity(intent);
            }
        });
        // 1
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FM1.class);
                startActivity(intent);
            }
        });
        //2
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FM2.class);
                startActivity(intent);
            }
        });
        //3
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FM3.class);
                startActivity(intent);
            }
        });
        //4
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FM4.class);
                startActivity(intent);
            }
        });
        //5
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FM5.class);
                startActivity(intent);
            }
        });

        //Set Event
//        setSingleEvent(mainGrid);
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


//    private void setSingleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            CardView cardView = (CardView) mainGrid.getChildAt(i);
//            ArrayList<String> allMoods = new ArrayList<String>(Arrays.asList("Happy", "Sad", "Sleepy", "Angry", "Confused", "a",
//                    "b", "c", "d", "e", "h", "i"));
//            final int finalI = i;
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (finalI == 0){
//                        Intent intent = new Intent(FMoods.this, FM0.class);
//                        startActivity(intent);
//                    }
//                    else if (finalI == 1){
//                        Intent intent = new Intent(FMoods.this, FM1.class);
//                        startActivity(intent);
//                    }
//
//
//
//                }
//            });
//        }
//    }
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