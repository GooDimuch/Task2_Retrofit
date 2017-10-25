package com.example.dimuch.task2_retrofit.data.model.weather;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dimuch on 10.10.2017.
 */

public class WeatherForThreeHours {

  private String sTimeOfDay;
  private Date date;
  private int iMaxTemperatureOfDay;
  private int iMinTemperatureOfDay;
  private String sWeatherOfDay;

  public WeatherForThreeHours() {
    this.sTimeOfDay = "00:00";
    this.date = defaultDate();
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override public String toString() {
    return "WeatherForThreeHours{"
        + "sTimeOfDay='"
        + sTimeOfDay
        + '\''
        + ", date="
        + date
        + ", iMaxTemperatureOfDay="
        + iMaxTemperatureOfDay
        + ", iMinTemperatureOfDay="
        + iMinTemperatureOfDay
        + ", sWeatherOfDay='"
        + sWeatherOfDay
        + '\''
        + '}';
  }
}
