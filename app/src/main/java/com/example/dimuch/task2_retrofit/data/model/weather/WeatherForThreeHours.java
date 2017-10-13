package com.example.dimuch.task2_retrofit.data.model.weather;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dimuch on 10.10.2017.
 */

public class WeatherForThreeHours {

  private String sTimeOfDay;
  private Date dayOfWeek;
  private int iMaxTemperatureOfDay;
  private int iMinTemperatureOfDay;
  private String sWeatherOfDay;

  public WeatherForThreeHours() {
    this.sTimeOfDay = "00:00";
    this.dayOfWeek = defaultDate();
    this.iMaxTemperatureOfDay = 0;
    this.iMinTemperatureOfDay = 0;
    this.sWeatherOfDay = "Rain";
  }

  private Date defaultDate() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(0);
    return calendar.getTime();
  }

  public String getsTimeOfDay() {
    return sTimeOfDay;
  }

  public int getiMaxTemperatureOfDay() {
    return iMaxTemperatureOfDay;
  }

  public void setiMaxTemperatureOfDay(int sMaxTemperatureOfDay) {
    this.iMaxTemperatureOfDay = sMaxTemperatureOfDay;
  }

  public int getiMinTemperatureOfDay() {
    return iMinTemperatureOfDay;
  }

  public void setiMinTemperatureOfDay(int sMinTemperatureOfDay) {
    this.iMinTemperatureOfDay = sMinTemperatureOfDay;
  }

  public String getsWeatherOfDay() {
    return sWeatherOfDay;
  }

  public void setsWeatherOfDay(String sWeatherOfDay) {
    this.sWeatherOfDay = sWeatherOfDay;
  }

  public Date getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(Date dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }
}
