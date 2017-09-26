package com.example.dimuch.task2_retrofit;

import android.os.AsyncTask;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dimuch on 26.09.2017.
 */

@InjectViewState
public class MyPresenter extends MvpPresenter<MyView> {

    private String sResultPost = "null";

    public MyPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        Log.wtf(Constants.MY_LOG, "onFirstViewAttach()");
        super.onFirstViewAttach();

        uploadResultPost();
        getViewState().toggleMessageLoading(true);
        getViewState().showMessage("Loading");
        getViewState().showResultPost(sResultPost);

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                try {
//                    getViewState().showToast("sleep " + Constants.INT_NUM_SECONDS_LOADING + " sec");
                    TimeUnit.SECONDS.sleep(Constants.INT_NUM_SECONDS_LOADING);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showMessage("Uploaded");
                getViewState().toggleMessageLoading(false);
                getViewState().showResultPost(sResultPost);
            }
        }.execute();
    }

    public void uploadResultPost() {
        RetrofitHelper.getApi().getData("01.12.2014")
                .map(SalesRateModel::toString)
//                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(adapter::addListNewsEntity);
                .subscribe(this::setsResultPost);
    }

    public void setsResultPost(String sResultPost) {
        this.sResultPost = sResultPost;
    }
}
