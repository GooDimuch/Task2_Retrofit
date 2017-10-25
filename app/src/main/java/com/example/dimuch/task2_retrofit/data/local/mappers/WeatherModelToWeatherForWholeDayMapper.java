package com.example.dimuch.task2_retrofit.data.local.mappers;

import com.example.dimuch.task2_retrofit.data.model.weather.WeatherForThreeHours;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherForWholeDay;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherList;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherModel;
import com.example.dimuch.task2_retrofit.utils.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import timber.log.Timber;

/**
 * Created by Dimuch on 13.10.2017.
 */

public class WeatherModelToWeatherForWholeDayMapper
    implements Mapper<WeatherModel, List<WeatherForWholeDay>> {

  private List<WeatherForWholeDay> mWeatherForWholeDayList;
  private List<WeatherForThreeHours> mWeatherForThreeHoursList;
  private WeatherModel mWeatherModel;

  @Override public List<WeatherForWholeDay> transform(WeatherModel weatherModel)
      throws RuntimeException {
    mWeatherModel = weatherModel;
    mWeatherForWholeDayList = new ArrayList<>();
    mWeatherForThreeHoursList = new ArrayList<>();

    if (!mWeatherModel.getWeatherList().isEmpty()) fillWeatherForThreeHoursArray();
    if (!mWeatherForThreeHoursList.isEmpty()) fillWeatherForWholeDayArray();

    return mWeatherForWholeDayList;
  }

  private void fillWeatherForThreeHoursArray() {
    for (WeatherList weatherList : mWeatherModel.getWeatherList()) {
      WeatherForThreeHours weatherForThreeHours = new WeatherForThreeHours();
      weatherForThreeHours.setDate(new Date(weatherList.getDt().longValue() * 1000));
      weatherForThreeHours.setiMaxTemperatureOfDay(weatherList.getMain().getTempMax().intValue());
      weatherForThreeHours.setiMinTemperatureOfDay(weatherList.getMain().getTempMin().intValue());
      weatherForThreeHours.setsWeatherOfDay(weatherList.getWeather().get(0).getMain());
      mWeatherForThreeHoursList.add(weatherForThreeHours);
    }
  }

  private void fillWeatherForWholeDayArray() {
    Date date = new Date(0);
    for (WeatherForThreeHours weatherForThreeHours : mWeatherForThreeHoursList) {
      Timber.e(weatherForThreeHours.getDate().toString());
      if (weatherForThreeHours.getDate().getDay() == date.getDay()) {
        mWeatherForWholeDayList.get(mWeatherForWholeDayList.size() - 1)
            .addWeatherForThreeHoursToList(weatherForThreeHours);
      } else {
        WeatherForWholeDay weatherForWholeDay = new WeatherForWholeDay();
        mWeatherForWholeDayList.add(weatherForWholeDay);
        weatherForWholeDay.addWeatherForThreeHoursToList(weatherForThreeHours);
        date = weatherForThreeHours.getDate();
      }
    }

    for (WeatherForWholeDay weatherForWholeDay : mWeatherForWholeDayList) {

      int maxTemperatureOfDay = Integer.MIN_VALUE;
      int minTemperatureOfDay = Integer.MAX_VALUE;

      for (WeatherForThreeHours weatherForThreeHours : weatherForWholeDay.getWeatherForThreeHoursList()) {
        if (maxTemperatureOfDay < weatherForThreeHours.getiMaxTemperatureOfDay()) {
          maxTemperatureOfDay = weatherForThreeHours.getiMaxTemperatureOfDay();
        }
        if (minTemperatureOfDay > weatherForThreeHours.getiMinTemperatureOfDay()) {
          minTemperatureOfDay = weatherForThreeHours.getiMinTemperatureOfDay();
        }
      }

      for (WeatherForThreeHours weatherForThreeHours : weatherForWholeDay.getWeatherForThreeHoursList()) {
        Timber.e(weatherForThreeHours.getDate().toString());
      }

      weatherForWholeDay.setsMaxTemperatureOfDay(
          String.valueOf(maxTemperatureOfDay - Constants.INT_DEGREE_CELSIUS));
      weatherForWholeDay.setsMinTemperatureOfDay(
          String.valueOf(minTemperatureOfDay - Constants.INT_DEGREE_CELSIUS));
      weatherForWholeDay.setsWeatherOfDay(
          weatherForWholeDay.getWeatherForThreeHoursList().get(0).getsWeatherOfDay());
      weatherForWholeDay.setDayOfWeek(
          weatherForWholeDay.getWeatherForThreeHoursList().get(0).getDate());
    }
  }
}
