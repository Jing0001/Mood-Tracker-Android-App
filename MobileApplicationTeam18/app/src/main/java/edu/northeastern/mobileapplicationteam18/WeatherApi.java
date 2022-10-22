package edu.northeastern.mobileapplicationteam18;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface WeatherApi {

    @GET("weather")
    Call<WeatherExample> getweather(@Query("q") String cityname,
                             @Query("appid") String apikey);
}
