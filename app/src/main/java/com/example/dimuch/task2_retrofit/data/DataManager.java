package com.example.dimuch.task2_retrofit.data;

import com.example.dimuch.task2_retrofit.data.local.mappers.WeatherModelToWeatherForWholeDayMapper;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherForWholeDay;
import com.example.dimuch.task2_retrofit.data.remote.RestApi;
import java.util.List;
import rx.Observable;
import timber.log.Timber;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class DataManager {

  private RestApi mRestApi;

  public DataManager(RestApi mRestApi) {
    this.mRestApi = mRestApi;
  }

  //public Observable<SalesRateModel> getData(String date) {
  //  return mRestApi.getData(date);
  //}

  public Observable<List<WeatherForWholeDay>> getWeatherData() {
    return mRestApi.getWeatherData()
        .doOnNext(weatherModel -> Timber.e(weatherModel.toString()))
        .map(
            weatherModel -> (new WeatherModelToWeatherForWholeDayMapper()).transform(weatherModel));
  }
}
