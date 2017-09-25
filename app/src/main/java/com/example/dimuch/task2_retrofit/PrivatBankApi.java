package com.example.dimuch.task2_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PrivatBankApi {

//    @GET("/api/get")
//    Call<List<PostModel>> getData(@Query("name") String resourceName, @Query("num") int count);

//    @GET("p24api/exchange_rates?json")
//    Call<SalesRateModel> getData(@Query("date") String date);

    @GET("p24api/exchange_rates?json")
    Observable<SalesRateModel> getData(@Query("date") String date);

}