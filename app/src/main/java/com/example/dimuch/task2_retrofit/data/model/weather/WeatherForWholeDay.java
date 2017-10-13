package com.example.dimuch.task2_retrofit.data.model.weather;

import com.example.dimuch.task2_retrofit.R;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Dimuch on 10.10.2017.
 */

public class WeatherForWholeDay {
  private List<WeatherForThreeHours> weatherForThreeHoursList;

  private String sDayOfWeek;
  private Date dayOfWeek;
  private String sTemperatureOfDay;
  private String sMaxTemperatureOfDay;
  private String sMinTemperatureOfDay;
  private String sWeatherOfDay;
  private int iWeatherIcon;
  public WeatherForWholeDay() {
    this.sDayOfWeek = "Monday";
    this.dayOfWeek = defaultDate();
    this.sTemperatureOfDay = "12'/5'";
    this.sWeatherOfDay = "Rain";
    this.iWeatherIcon = R.mipmap.ic_launcher;
  }

  private Date defaultDate() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(0);
    return calendar.getTime();
  }

  public List<WeatherForThreeHours> getWeatherForThreeHoursList() {
    return weatherForThreeHoursList;
  }

  public void addWeatherForThreeHoursToList(WeatherForThreeHours weatherForThreeHours) {
    weatherForThreeHoursList.add(weatherForThreeHours);
  }

  public String getsDayOfWeek() {
    return sDayOfWeek;
  }

  public String getsTemperatureOfDay() {
    return sTemperatureOfDay;
  }

  public String getsMaxTemperatureOfDay() {
    return sMaxTemperatureOfDay;
  }

  public void setsMaxTemperatureOfDay(String sMaxTemperatureOfDay) {
    this.sMaxTemperatureOfDay = sMaxTemperatureOfDay;
  }

  public String getsMinTemperatureOfDay() {
    return sMinTemperatureOfDay;
  }

  public void setsMinTemperatureOfDay(String sMinTemperatureOfDay) {
    this.sMinTemperatureOfDay = sMinTemperatureOfDay;
  }

  public String getsWeatherOfDay() {
    return sWeatherOfDay;
  }

  public void setsWeatherOfDay(String sWeatherOfDay) {
    this.sWeatherOfDay = sWeatherOfDay;
  }

  public int getiWeatherIcon() {
    return iWeatherIcon;
  }

  public void setiWeatherIcon(int iWeatherIcon) {
    this.iWeatherIcon = iWeatherIcon;
  }

  public Date getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(Date dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  @Override public String toString() {
    return "WeatherForWholeDay{"
        + "weatherForThreeHoursList="
        + weatherForThreeHoursList
        + ", sDayOfWeek='"
        + sDayOfWeek
        + '\''
        + ", dayOfWeek="
        + dayOfWeek
        + ", sTemperatureOfDay='"
        + sTemperatureOfDay
        + '\''
        + ", sMaxTemperatureOfDay='"
        + sMaxTemperatureOfDay
        + '\''
        + ", sMinTemperatureOfDay='"
        + sMinTemperatureOfDay
        + '\''
        + ", sWeatherOfDay='"
        + sWeatherOfDay
        + '\''
        + ", iWeatherIcon="
        + iWeatherIcon
        + '}';
  }
}
