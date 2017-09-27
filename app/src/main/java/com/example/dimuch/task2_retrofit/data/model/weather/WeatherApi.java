package com.example.dimuch.task2_retrofit.data.model.weather;

import com.example.dimuch.task2_retrofit.data.model.privatbank.SalesRateModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherApi {

  @GET("data/2.5/forecast?") Observable<WeatherModel> getWeather(@Query("id") String id,
      @Query("APPID") String appId);
}