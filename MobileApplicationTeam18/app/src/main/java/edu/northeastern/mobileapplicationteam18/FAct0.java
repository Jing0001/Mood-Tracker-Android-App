package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class FAct0 extends AppCompatActivity {

    private RecyclerView recyclerView;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact0);
        recyclerView = findViewById(R.id.rec0);
        LinearLayoutManager lmg = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lmg);

        ArrayList<FModel> models = new ArrayList<>();{
//            ImageView i1;
//            i1 = (ImageView) findViewById(R.drawable.anger);
            models.add(new FModel(R.drawable.anger, "Name1", "Detail1"));
            models.add(new FModel(R.drawable.fatigue, "Name2", "Detail2"));
        }
        FAdapter myAdapter = new FAdapter(models);
        recyclerView.setAdapter(myAdapter);
    }
}