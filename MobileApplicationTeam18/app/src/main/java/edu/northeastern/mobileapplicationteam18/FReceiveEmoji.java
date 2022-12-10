package edu.northeastern.mobileapplicationteam18;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FReceiveEmoji extends AppCompatActivity {
    private List<Emoji> Emojis;
    private DatabaseReference myDataBase;
    BottomNavigationView bottomNavigationView;
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freceive_emoji);

        Bundle extras = getIntent().getExtras();
        System.out.println("extras in received: " + extras);
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        myDataBase = FirebaseDatabase.getInstance().getReference();
        updateReceivedRecordsRV();
        readEmojisFromDB();

        // for navigation bar
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.navigationBar);
        bottomNavigationView.setSelectedItemId(R.id.messaging);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.messaging:
                        return true;

                    case R.id.home:
                        Intent intent = new Intent(getApplicationContext(),FMoods.class);
                        intent.putExtra("user_name", userName);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.tracking:
                        Intent intentTracking = new Intent(getApplicationContext(),FMoodSummary.class);
                        intentTracking.putExtra("user_name", userName);
                        startActivity(intentTracking);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.moment:
                        Intent intentMoment = new Intent(getApplicationContext(),FMemory.class);
                        intentMoment.putExtra("user_name", userName);
                        startActivity(intentMoment);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        }); //end of navigation bar
    }

    private void updateReceivedRecordsRV() {
        RecyclerView receivedRecordsRV = findViewById(R.id.freceivedRecordsRV);
        receivedRecordsRV.setLayoutManager(new LinearLayoutManager(this));
        receivedRecordsRV.setAdapter(new FEmojiAdapter(Emojis));
    }

    private void readEmojisFromDB() {
        Emojis = new ArrayList<>();
        myDataBase.child("emojis").get().addOnCompleteListener((task) -> {
            HashMap<String, HashMap<String, String>> tempMap = (HashMap) task.getResult().getValue();
            System.out.println("received key set: " + tempMap.keySet()+ " key set__________");
            if (tempMap == null) {
                return;
            }
            for (String entryKey : tempMap.keySet()) {
                String fromUser = Objects.requireNonNull(tempMap.get(entryKey)).get("fromUser");
                String id = String.valueOf(Objects.requireNonNull(tempMap.get(entryKey)).get("id"));
                String sendTime = Objects.requireNonNull(tempMap.get(entryKey)).get("sendTime");
                String toUser = Objects.requireNonNull(tempMap.get(entryKey)).get("toUser");
                System.out.println("to user in received before__: " + toUser);
                System.out.println("myName in received: " + userName);

                if (toUser != null && toUser.equals(userName)) {
                    System.out.println("to user in if__: " + toUser);
                    Emojis.add(new Emoji(Integer.parseInt(id), fromUser, toUser, sendTime));
                }
            }
            Emojis.sort(Collections.reverseOrder());
            for (Emoji e : Emojis) {
                System.out.println("received list type: " + Emojis.getClass().getSimpleName() + " history__________");
                System.out.println("received list from: " + e.fromUser+ " history__________");
                System.out.println("received list to: " + e.toUser+ " history__________");
                System.out.println("received list id: " + e.id+ " history__________");
                System.out.println("_______________________________________________________________________________");
            }
            updateReceivedRecordsRV();
        });
    }
}