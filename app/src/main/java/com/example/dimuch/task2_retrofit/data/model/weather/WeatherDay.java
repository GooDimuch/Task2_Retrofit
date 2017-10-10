package com.example.dimuch.task2_retrofit.data.model.weather;

import com.example.dimuch.task2_retrofit.R;

/**
 * Created by Dimuch on 10.10.2017.
 */

public class WeatherDay {

  private String dayOfWeek = "Monday";
  private String temperatureOfDay = "12'/5'";
  private String weatherOfDay = "Rain";
  private int weatherIcon = R.mipmap.ic_launcher;

  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public String getTemperatureOfDay() {
    return temperatureOfDay;
  }

  public void setTemperatureOfDay(String temperatureOfDay) {
    this.temperatureOfDay = temperatureOfDay;
  }

  public String getWeatherOfDay() {
    return weatherOfDay;
  }

  public void setWeatherOfDay(String weatherOfDay) {
    this.weatherOfDay = weatherOfDay;
  }

  public int getWeatherIcon() {
    return weatherIcon;
  }

  public void setWeatherIcon(int weatherIcon) {
    this.weatherIcon = weatherIcon;
  }
}
