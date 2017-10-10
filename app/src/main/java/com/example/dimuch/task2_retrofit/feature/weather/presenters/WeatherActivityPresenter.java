package com.example.dimuch.task2_retrofit.feature.weather.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task2_retrofit.App;
import com.example.dimuch.task2_retrofit.data.DataManager;
import com.example.dimuch.task2_retrofit.feature.weather.views.IWeatherActivityView;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Dimuch on 26.09.2017.
 */

@InjectViewState public class WeatherActivityPresenter extends MvpPresenter<IWeatherActivityView> {

  @Inject String testMessage;
  @Inject DataManager mDataManager;

  public WeatherActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    //Log.wtf(Constants.MY_LOG, "onFirstViewAttach()");
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    uploadResultPost();

  }

  public void uploadResultPost() {
    mDataManager.getWeatherData()
        .subscribe(getViewState()::showResultPost, Timber::wtf);
  }
}
