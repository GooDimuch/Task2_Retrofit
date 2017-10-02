package com.example.dimuch.task2_retrofit.data.model.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

  @SerializedName("temp") @Expose private Double temp;
  @SerializedName("temp_min") @Expose private Double tempMin;
  @SerializedName("temp_max") @Expose private Double tempMax;
  @SerializedName("pressure") @Expose private Double pressure;
  @SerializedName("sea_level") @Expose private Double seaLevel;
  @SerializedName("grnd_level") @Expose private Double grndLevel;
  @SerializedName("humidity") @Expose private Integer humidity;
  @SerializedName("temp_kf") @Expose private Integer tempKf;

  /**
   * No args constructor for use in serialization
   */
  public Main() {
  }

  /**
   *
   * @param seaLevel
   * @param humidity
   * @param pressure
   * @param grndLevel
   * @param tempMax
   * @param temp
   * @param tempKf
   * @param tempMin
   */
  public Main(Double temp, Double tempMin, Double tempMax, Double pressure, Double seaLevel,
      Double grndLevel, Integer humidity, Integer tempKf) {
    super();
    this.temp = temp;
    this.tempMin = tempMin;
    this.tempMax = tempMax;
    this.pressure = pressure;
    this.seaLevel = seaLevel;
    this.grndLevel = grndLevel;
    this.humidity = humidity;
    this.tempKf = tempKf;
  }

  public Double getTemp() {
    return temp;
  }

  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public Double getTempMin() {
    return tempMin;
  }

  public void setTempMin(Double tempMin) {
    this.tempMin = tempMin;
  }

  public Double getTempMax() {
    return tempMax;
  }

  public void setTempMax(Double tempMax) {
    this.tempMax = tempMax;
  }

  public Double getPressure() {
    return pressure;
  }

  public void setPressure(Double pressure) {
    this.pressure = pressure;
  }

  public Double getSeaLevel() {
    return seaLevel;
  }

  public void setSeaLevel(Double seaLevel) {
    this.seaLevel = seaLevel;
  }

  public Double getGrndLevel() {
    return grndLevel;
  }

  public void setGrndLevel(Double grndLevel) {
    this.grndLevel = grndLevel;
  }

  public Integer getHumidity() {
    return humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  public Integer getTempKf() {
    return tempKf;
  }

  public void setTempKf(Integer tempKf) {
    this.tempKf = tempKf;
  }
}