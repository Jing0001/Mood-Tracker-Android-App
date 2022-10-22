package edu.northeastern.mobileapplicationteam18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;

public class Weather extends AppCompatActivity {

    EditText et;
    TextView tv;
    String url = "api.openweathermap.org/data/2.5/weather?q={city name}&appid={your api key}";
    String apikey = "eea3ae443837e9afaabb58ba6ea17b13";
    LocationManager manager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

    }

    public void getweather(View v){
        System.out.println("hhhhhhhhhhhhhh");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApi myapi=retrofit.create(WeatherApi.class);
        Call<WeatherExample> examplecall=myapi.getweather(et.getText().toString().trim(),apikey);
        examplecall.enqueue(new Callback<WeatherExample>() {
            @Override
            public void onResponse(Call<WeatherExample> call, Response<WeatherExample> response) {
                if(response.code()==404){
                    Toast.makeText(Weather.this,"Please Enter a valid City",Toast.LENGTH_LONG).show();
                }
                else if(!(response.isSuccessful())){
                    Toast.makeText(Weather.this,response.code()+" ",Toast.LENGTH_LONG).show();
                    return;
                }
                WeatherExample mydata=response.body();
                WeatherDetails main=mydata.getWeatherDetails();
                Double temp=main.getTemp();
                Integer temperature=(int)(temp-273.15);
                tv.setText(String.valueOf(temperature)+"C");
            }

            @Override
            public void onFailure(Call<WeatherExample> call, Throwable t) {
                Toast.makeText(Weather.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });



    }
}