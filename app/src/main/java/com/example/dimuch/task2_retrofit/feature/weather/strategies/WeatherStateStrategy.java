package com.example.dimuch.task2_retrofit.feature.weather.strategies;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.StateStrategy;
import java.util.List;

/**
 * Created by Dimuch on 26.09.2017.
 */

public class WeatherStateStrategy implements StateStrategy {
  @Override public <View extends MvpView> void beforeApply(List<ViewCommand<View>> currentState,
      ViewCommand<View> incomingCommand) {

  }

  @Override public <View extends MvpView> void afterApply(List<ViewCommand<View>> currentState,
      ViewCommand<View> incomingCommand) {

  }
}
