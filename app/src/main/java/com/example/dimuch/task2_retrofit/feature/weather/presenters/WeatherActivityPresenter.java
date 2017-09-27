package com.example.dimuch.task2_retrofit.feature.weather.presenters;

import android.os.AsyncTask;
import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task2_retrofit.data.DataManager;
import com.example.dimuch.task2_retrofit.data.local.RetrofitHelper;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherModel;
import com.example.dimuch.task2_retrofit.feature.weather.views.IWeatherActivityView;
import com.example.dimuch.task2_retrofit.utils.Constants;
import java.util.concurrent.TimeUnit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dimuch on 26.09.2017.
 */

@InjectViewState public class WeatherActivityPresenter extends MvpPresenter<IWeatherActivityView> {

  private String mResultPost = "null";
  private DataManager mDataManager;

  public WeatherActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    //Log.wtf(Constants.MY_LOG, "onFirstViewAttach()");
    super.onFirstViewAttach();

    uploadResultPost();
    getViewState().toggleMessageLoading(true);
    getViewState().showMessage("Loading");
    getViewState().showResultPost(mResultPost);

    new AsyncTask<Void, Void, Void>() {

      @Override protected Void doInBackground(Void... params) {
        try {
          //getViewState().showToast("sleep " + Constants.INT_NUM_SECONDS_LOADING + " sec");
          TimeUnit.SECONDS.sleep(Constants.INT_NUM_SECONDS_LOADING);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return null;
      }

      @Override protected void onPostExecute(Void aVoid) {
        getViewState().showMessage("Uploaded");
        getViewState().toggleMessageLoading(false);
        getViewState().showResultPost(mResultPost);
      }
    }.execute();
  }

  public void uploadResultPost() {
    //RetrofitHelper.getPrivatBankApi()
    //    .getData("01.12.2014")
    //    .map(SalesRateModel::toString)
    //    //.toList()
    //    .subscribeOn(Schedulers.io())
    //    .observeOn(AndroidSchedulers.mainThread())
    //    //.subscribe(adapter::addListNewsEntity);
    //    .subscribe(this::setmResultPost);

    mDataManager.getWeatherData()
        .subscribe(this::setmResultPost, throwable -> Log.wtf("myLog", throwable));
  }

  public void setmResultPost(String mResultPost) {
    this.mResultPost = mResultPost;
  }
}
