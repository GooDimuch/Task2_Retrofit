package com.example.dimuch.task2_retrofit.data.model.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherModel {

  @SerializedName("cod") @Expose private String cod;
  @SerializedName("message") @Expose private Double message;
  @SerializedName("cnt") @Expose private Integer cnt;
  @SerializedName("weatherList") @Expose private java.util.List<WeatherList> weatherList = null;
  @SerializedName("city") @Expose private City city;

  /**
   * No args constructor for use in serialization
   */
  public WeatherModel() {
  }

  /**
   *
   * @param message
   * @param cnt
   * @param cod
   * @param weatherList
   * @param city
   */
  public WeatherModel(String cod, Double message, Integer cnt,
      java.util.List<WeatherList> weatherList, City city) {
    super();
    this.cod = cod;
    this.message = message;
    this.cnt = cnt;
    this.weatherList = weatherList;
    this.city = city;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

  public Double getMessage() {
    return message;
  }

  public void setMessage(Double message) {
    this.message = message;
  }

  public Integer getCnt() {
    return cnt;
  }

  public void setCnt(Integer cnt) {
    this.cnt = cnt;
  }

  public java.util.List<WeatherList> getWeatherList() {
    return weatherList;
  }

  public void setWeatherList(java.util.List<WeatherList> weatherList) {
    this.weatherList = weatherList;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override public String toString() {
    return "WeatherModel{"
        + "cod='"
        + cod
        + '\''
        + ", message="
        + message
        + ", cnt="
        + cnt
        + ", weatherList="
        + weatherList
        + ", city="
        + city
        + '}';
  }
}
