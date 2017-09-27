package com.example.dimuch.task2_retrofit.data;

import com.example.dimuch.task2_retrofit.data.model.privatbank.SalesRateModel;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherModel;
import com.example.dimuch.task2_retrofit.data.remote.RestApi;
import rx.Observable;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class DataManager {

  private RestApi mRestApi;

  public DataManager(RestApi mRestApi) {
    this.mRestApi = mRestApi;
  }

  public Observable<SalesRateModel> getData(String date) {
    return mRestApi.getData(date);
  }

  public Observable<String> getWeatherData() {
    return mRestApi.getWeatherData();
  }
}
