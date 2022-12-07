package edu.northeastern.mobileapplicationteam18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class FMoods extends AppCompatActivity implements LocationListener {
    //    public Map<String, Integer> moodSelectCount = new HashMap<String, Integer>();
    private LocationManager locationManager;
    private static final int PERMISSIONS_FINE_LOCATION = 99;
    GridLayout mainGrid;
    Integer count = 0;
    Integer cntMood = 0;
    String userName;
    private TextView currUserNameTV;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getLocation();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmoods);
        Bundle extras = getIntent().getExtras();
        System.out.println("extras in moods: " + extras);
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        System.out.println("userName: " + userName);
        currUserNameTV = (TextView) findViewById(R.id.currentUser);
        currUserNameTV.setText(userName);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

//        Button calendar = (Button) findViewById(R.id.calendar);
        Button toMoodSummaryBtn = (Button) findViewById(R.id.toMoodSummary);
        Button memory = (Button) findViewById(R.id.memory);
        Button send = (Button) findViewById(R.id.fSend);
        CardView cardView0 = (CardView) mainGrid.getChildAt(0);
        CardView cardView1 = (CardView) mainGrid.getChildAt(1);
        CardView cardView2 = (CardView) mainGrid.getChildAt(2);
        CardView cardView3 = (CardView) mainGrid.getChildAt(3);
        CardView cardView4 = (CardView) mainGrid.getChildAt(4);
        CardView cardView5 = (CardView) mainGrid.getChildAt(5);
        CardView cardView6 = (CardView) mainGrid.getChildAt(6);


//        calendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FMoods.this, FCalendar.class);
////                Intent intent = new Intent(FMoods.this, FCalendarWeekView.class);
//                startActivity(intent);
//            }
//        });

        toMoodSummaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FMoodSummary.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FMoods.this, FMemory.class);
                intent.putExtra("user_name", userName);
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

        // 0 -happy
        cardView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Happy");
                Integer cnt = readCountFromDB("Happy") + 1 ;
                postToDatabase("Happy", cnt);
                Intent intent = new Intent(FMoods.this, FM0happy.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });


        // 1:press angry mood
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Angry");
                Integer cnt = readCountFromDB("Angry") + 1 ;
                postToDatabase("Angry", cnt);
                Intent intent = new Intent(FMoods.this, FM1Angry.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        //2-sad
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Sad");
                Integer cnt = readCountFromDB("Sad") + 1 ;
                postToDatabase("Sad", cnt);
                Intent intent = new Intent(FMoods.this, FM2Sad.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        //3 - Histerical
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Hysterical");
                Integer cnt = readCountFromDB("Hysterical") + 1 ;
                postToDatabase("Hysterical", cnt);
                Intent intent = new Intent(FMoods.this, FM3Hysterical.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        //4 -embarrassed
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Embarrassment");
                Integer cnt = readCountFromDB("Embarrassment") + 1 ;
                postToDatabase("Embarrassment", cnt);
                Intent intent = new Intent(FMoods.this, FM4Embarrassed.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        //5 -Fatigued
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Fatigued");
                Integer cnt = readCountFromDB("Fatigued") + 1 ;
                postToDatabase("Fatigued", cnt);
                Intent intent = new Intent(FMoods.this, FM5Fatigued.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        count++;
        if (count == 2) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Click again to sign out", Toast.LENGTH_SHORT).show();
        }
    }

    // get user's location(la, lo, city name) when sign in and post to database
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(FMoods.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, (LocationListener) this);
        } else {
            ActivityCompat.requestPermissions(FMoods.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        postToDatabase(location);
    }

    public void postToDatabase(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        String city = getCity(latitude, longitude);

        databaseReference.child("FUser").child(userName).child("location").child("latitude").setValue(latitude);
        databaseReference.child("FUser").child(userName).child("location").child("longitude").setValue(longitude);
        databaseReference.child("FUser").child(userName).child("location").child("city").setValue(city);
        databaseReference.child("FUser").child(userName).child("city").setValue(city);
    }

    // get city name by la and lo
    private String getCity(double la, double lo) {
        String cityName = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(la, lo, 10);
            if (addresses.size() > 0) {
                for (Address ad : addresses) {
                    if (ad.getLocality() != null && ad.getLocality().length() > 0) {
                        cityName = ad.getLocality();
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    // read mood counts from DB
    private Integer readCountFromDB(String m) {
        databaseReference.child("FUser").child(userName).child("MoodCount").get().addOnCompleteListener((task) -> {
            HashMap<String, Long> countMap = (HashMap) task.getResult().getValue();
            System.out.println("Wen test: Angry: " + countMap.get("Angry"));
//            System.out.println("Wen test: Happy: " + countMap.get("Happy"));
            if (countMap != null && countMap.containsKey(m)) {
                System.out.println("arrives here___________");
                System.out.println(countMap.get(m).toString() +"type___________");
             cntMood = Math.toIntExact(countMap.get(m));
            } else {
                cntMood = 0;
            }
        });
        return cntMood;
    }

    // write mood count to DB
    public void postToDatabase(String m, Integer cnt) {
        databaseReference.child("FUser").child(userName).child("MoodCount").child(m).setValue(cnt);
    }
}


