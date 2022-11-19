package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Mood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwelcome);

        Button playVideo = (Button) findViewById(R.id.play);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        VideoView moodyVideo = findViewById(R.id.moody);
        String urlPath2 = "android.resource://edu.northeastern.mobileapplicationteam18/" + R.raw.moody;
        Uri uri2 = Uri.parse(urlPath2);
        moodyVideo.setVideoURI(uri2);
        moodyVideo.requestFocus();
        moodyVideo.start();

        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoView moodyVideo = findViewById(R.id.moody);
                String urlPath2 = "android.resource://edu.northeastern.mobileapplicationteam18/" + R.raw.moody;
                Uri uri2 = Uri.parse(urlPath2);
                moodyVideo.setVideoURI(uri2);
                moodyVideo.requestFocus();
                moodyVideo.start();
            }
        });
    }
}