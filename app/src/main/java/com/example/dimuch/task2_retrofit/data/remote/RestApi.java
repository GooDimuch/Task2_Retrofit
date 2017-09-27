package com.example.dimuch.task2_retrofit.data.remote;

import com.example.dimuch.task2_retrofit.data.model.PrivatBankApi;
import com.example.dimuch.task2_retrofit.data.model.SalesRateModel;
import com.example.dimuch.task2_retrofit.data.model.WeatherModel;

import rx.Observable;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class RestApi {
    private final PrivatBankApi api;

    public RestApi(PrivatBankApi api) {
        this.api = api;
    }

    public Observable<SalesRateModel> getData(String date) {
        return api.getData(date);
    }

    public Observable<WeatherModel> getWeather(String id, String appId) {
        return api.getWeather(id, appId);
    }
}
