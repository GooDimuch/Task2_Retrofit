package com.example.dimuch.task2_retrofit;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dimuch on 26.09.2017.
 */

@InjectViewState
public class MyPresenter extends MvpPresenter<MyView> {

    public MyPresenter() {
        getViewState().showResultPost();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().uploadResultPost();
        getViewState().toggleMessageLoading(true);
        getViewState().showMessage("Loading");

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
                getViewState().showResultPost();
            }
        }.execute();
    }
}
