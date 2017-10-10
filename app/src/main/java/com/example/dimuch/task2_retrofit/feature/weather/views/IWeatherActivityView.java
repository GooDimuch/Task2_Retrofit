package com.example.dimuch.task2_retrofit.feature.weather.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherDay;
import java.util.List;

/**
 * Created by Dimuch on 26.09.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IWeatherActivityView
    extends MvpView {

  @StateStrategyType(AddToEndSingleStrategy.class) void showResultPost(String sResultPost);

  @StateStrategyType(AddToEndSingleStrategy.class) void showWeatherArray(List<WeatherDay> weatherArray);

  void showToast(String sToastMessage);
}
