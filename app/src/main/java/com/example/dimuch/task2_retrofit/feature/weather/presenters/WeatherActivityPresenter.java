package com.example.dimuch.task2_retrofit.feature.weather.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task2_retrofit.App;
import com.example.dimuch.task2_retrofit.data.DataManager;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherForWholeDay;
import com.example.dimuch.task2_retrofit.feature.weather.views.IWeatherActivityView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
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

    //getViewState().showWeatherArray(tempWeatherArray());
    //getViewState().showResultPost(testMessage);
    uploadResultPost();
  }

  private List<WeatherForWholeDay> tempWeatherArray() {
    List<WeatherForWholeDay> weatherArray = new ArrayList<>();
    weatherArray.add(new WeatherForWholeDay());
    weatherArray.add(new WeatherForWholeDay());
    weatherArray.add(new WeatherForWholeDay());
    return weatherArray;
  }

  public void uploadResultPost() {
    mDataManager.getWeatherData()
        .doOnNext(weatherForWholeDays -> {
          for (WeatherForWholeDay element : weatherForWholeDays) {
            Timber.e(element.toString());
          }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        //.map(Object::toString)
        .subscribe(getViewState()::showWeatherArray, Timber::wtf);
  }
}
