package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FMoodSummary extends AppCompatActivity {
    String userName;
    private TextView happyNumTV;
    private TextView sadNumTV;
    private TextView angryNumTV;
    private TextView embarrNumTV;
    private TextView hystNumTV;
    private TextView fatiNumTV;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmood_summary);
        happyNumTV = (TextView) findViewById(R.id.happyNumber);
        sadNumTV = (TextView) findViewById(R.id.sadNumber);
        angryNumTV = (TextView) findViewById(R.id.angryNumber);
        embarrNumTV = (TextView) findViewById(R.id.embNumber);
        hystNumTV = (TextView) findViewById(R.id.hysNumber);
        fatiNumTV = (TextView) findViewById(R.id.fatNumber);
        Bundle extras = getIntent().getExtras();
        System.out.println("extras in moods: " + extras);
        if (extras != null) {
            userName = extras.getString("user_name");
        }

        readCountFromDB();

    }

    // read mood counts from DB
    private void readCountFromDB() {
        databaseReference.child("FUser").child(userName).child("MoodCount").get().addOnCompleteListener((task) -> {
            HashMap<String, Long> countMap = (HashMap) task.getResult().getValue();
            if (countMap != null) {
                System.out.println("countMap.keySet() :" + countMap.keySet() + "sum_____");
                System.out.println("countMap.values() :" + countMap.values() + "sum_____");
                for(String mood:countMap.keySet()){
                    if(mood.equals("Happy")){
                        String cntMood = countMap.get(mood) + "";
                        happyNumTV.setText(cntMood);
                    }
                    else if(mood.equals("Sad")){
                        String cntMood = countMap.get(mood) + "";
                        sadNumTV.setText(cntMood);
                    }
                    else if(mood.equals("Angry")){
                        String cntMood = countMap.get(mood) + "";
                        angryNumTV.setText(cntMood);
                    }
                    else if(mood.equals("Embarrassment")){
                        String cntMood = countMap.get(mood) + "";
                        embarrNumTV.setText(cntMood);
                    }
                    else if(mood.equals("Hysterical")){
                        String cntMood = countMap.get(mood) + "";
                        hystNumTV.setText(cntMood);
                    }else{
                            String cntMood = countMap.get(mood) + "";
                            fatiNumTV.setText(cntMood);

                    }
                }
            }
        });
    } // end of read mood count from db

    // generate mood summary
//    private void readCountFromDB()

}