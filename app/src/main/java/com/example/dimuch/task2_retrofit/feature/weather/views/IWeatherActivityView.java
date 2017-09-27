package com.example.dimuch.task2_retrofit.feature.weather.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.dimuch.task2_retrofit.feature.weather.strategies.WeatherStateStrategy;

/**
 * Created by Dimuch on 26.09.2017.
 */

@StateStrategyType(WeatherStateStrategy.class) public interface IWeatherActivityView
    extends MvpView {

  void showResultPost(String sResultPost);

  void showMessage(String sLoadingMessage);

  void showToast(String sToastMessage);

  @StateStrategyType(SkipStrategy.class) void toggleMessageLoading(boolean isLoading);
}
