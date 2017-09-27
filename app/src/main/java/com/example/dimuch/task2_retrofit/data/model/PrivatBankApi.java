package com.example.dimuch.task2_retrofit.data.model;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PrivatBankApi {

  //    @GET("p24api/exchange_rates?json")
  //    Call<SalesRateModel> getData(@Query("date") String date);

  @GET("p24api/exchange_rates?json") Observable<SalesRateModel> getData(@Query("date") String date);

  @GET("p24api/exchange_rates?json") Observable<WeatherModel> getWeather(
      @Query("date") String date);
}