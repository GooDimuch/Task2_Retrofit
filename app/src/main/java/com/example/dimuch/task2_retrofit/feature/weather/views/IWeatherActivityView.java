package com.example.dimuch.task2_retrofit.feature.weather.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.dimuch.task2_retrofit.feature.weather.strategies.WeatherStateStrategy;

/**
 * Created by Dimuch on 26.09.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IWeatherActivityView
    extends MvpView {

  @StateStrategyType(AddToEndSingleStrategy.class) void showResultPost(String sResultPost);

  void showToast(String sToastMessage);
}
