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
import java.util.List;
import java.util.Locale;

public class FMoods extends AppCompatActivity implements LocationListener {
    private LocationManager locationManager;
    private static final int PERMISSIONS_FINE_LOCATION = 99;
    GridLayout mainGrid;
    Integer count = 0;
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
        System.out.println("extras in moods: " + extras );
        if (extras != null) {
            userName = extras.getString("user_name");
        }
        System.out.println("userName: " + userName);
        currUserNameTV = (TextView) findViewById(R.id.currentUser);
        currUserNameTV.setText(userName);
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
                databaseReference.child("FUser").child(userName).child("mood").setValue("Happy");
                Intent intent = new Intent(FMoods.this, FM0happy.class);
                intent.putExtra("user_name", userName);
                startActivity(intent);
            }
        });

        // try to add the selected mood to data base
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child("FUser").child(userName).child("mood").setValue("Happy");
                databaseReference.child("FUser").child(userName).child("city").setValue(("1"));
//                if(databaseReference.child("FMoodTrack").child(userName).getValue("Angry") == null){
//                    databaseReference.child("FMoodTrack").child(userName).child("Angry").setValue("1");
//                }else{
//                    String count = databaseReference.child("FMoodTrack").child(userName).getValue("Angry");
//                    databaseReference.child("FMoodTrack").child(userName).child("Angry").setValue(count);
//                }
//                databaseReference.child("FMoods").child(userName).child("Happy").setValue(("1"));
//                System.out.println("Fmoods table:",databaseReference.child("FMoods").child(userName).getKey("Happy"));
                Intent intent = new Intent(FMoods.this, FM1.class);
                startActivity(intent);
            }
        });

        // 1:press angry mood
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Angry");
                Intent intent = new Intent(FMoods.this, FM1.class);
                startActivity(intent);
            }
        });
        //2
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Sad");
                Intent intent = new Intent(FMoods.this, FM2.class);
                startActivity(intent);
            }
        });
        //3
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Hysterical");
                Intent intent = new Intent(FMoods.this, FM3.class);
                startActivity(intent);
            }
        });
        //4
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Embarrassment");
//                databaseReference.child("FMoods").child(userName).child()
                Intent intent = new Intent(FMoods.this, FM4.class);
                startActivity(intent);
            }
        });
        //5
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("FUser").child(userName).child("mood").setValue("Fatigued");

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
//                        Intent intent = new Intent(FMoods.this, FM0happy.class);
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

    // get user's location(la, lo, city name) when sign in and post to database
    private void getLocation(){
        if (ActivityCompat.checkSelfPermission(FMoods.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, (LocationListener) this);
        }
        else{
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
    private String getCity(double la, double lo){
        String cityName = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        try{
            addresses = geocoder.getFromLocation(la,lo,10);
            if (addresses.size() > 0){
                for(Address ad : addresses){
                    if (ad.getLocality() != null && ad.getLocality().length() > 0){
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

}