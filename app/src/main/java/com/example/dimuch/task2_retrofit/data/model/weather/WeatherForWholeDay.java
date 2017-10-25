package com.example.dimuch.task2_retrofit.data.model.weather;

import com.example.dimuch.task2_retrofit.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dimuch on 10.10.2017.
 */

public class WeatherForWholeDay {
  private List<WeatherForThreeHours> weatherForThreeHoursList;

  private Date dayOfWeek;
  private String sMaxTemperatureOfDay;
  private String sMinTemperatureOfDay;
  private String sWeatherOfDay;
  private int iWeatherIcon;

  public WeatherForWholeDay() {
    weatherForThreeHoursList = new ArrayList<>();
    this.dayOfWeek = new Date(0);
    this.sWeatherOfDay = "*NULL*";
    this.iWeatherIcon = R.mipmap.ic_launcher;
  }

  public List<WeatherForThreeHours> getWeatherForThreeHoursList() {
    return weatherForThreeHoursList;
  }

  public void addWeatherForThreeHoursToList(WeatherForThreeHours weatherForThreeHours) {
    weatherForThreeHoursList.add(weatherForThreeHours);
  }

  public String getsDayOfWeek() {
    return transformIntToStringDayOfWeek(dayOfWeek.getDay());
  }

  private String transformIntToStringDayOfWeek(int day) {
    switch (day) {
      case 0:
        return "Sunday";
      case 1:
        return "Monday";
      case 2:
        return "Tuesday";
      case 3:
        return "Wednesday";
      case 4:
        return "Thursday";
      case 5:
        return "Friday";
      case 6:
        return "Saturday";
      default: return "*NULL*";
    }
  }

  public String getsTemperatureOfDay() {
    return sMaxTemperatureOfDay + "' / " + sMinTemperatureOfDay + "'";
  }

  public void setsMaxTemperatureOfDay(String sMaxTemperatureOfDay) {
    this.sMaxTemperatureOfDay = sMaxTemperatureOfDay;
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

  public void setDayOfWeek(Date dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  @Override public String toString() {
    return "WeatherForWholeDay{"
        + ", sDayOfWeek='"
        + transformIntToStringDayOfWeek(dayOfWeek.getDay())
        + '\''
        + ", dayOfWeek="
        + dayOfWeek
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
