package com.example.dimuch.task2_retrofit.data.remote;

import com.example.dimuch.task2_retrofit.data.local.RetrofitHelper;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherApi;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherModel;
import com.example.dimuch.task2_retrofit.utils.Constants;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class RestApi {
  //private final PrivatBankApi privatbankApi;
  private final WeatherApi weatherApi;

  public RestApi(WeatherApi weatherApi) {
    //this.privatbankApi = privatbankApi;
    this.weatherApi = weatherApi;
  }

  //public Observable<SalesRateModel> getData(String date) {
  //  return privatbankApi.getData(date);
  //}

  public Observable<String> getWeatherData() {
    return weatherApi.getWeather(Constants.WEATHER_ID, Constants.WEATHER_APPID)
        .map(WeatherModel::toString)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
