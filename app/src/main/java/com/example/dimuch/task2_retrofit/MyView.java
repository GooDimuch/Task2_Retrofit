package com.example.dimuch.task2_retrofit;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Dimuch on 26.09.2017.
 */

interface MyView extends MvpView {

    void showResultPost(String sResultPost);

    void showMessage(String sLoadingMessage);

    void showToast(String sToastMessage);

    void toggleMessageLoading(boolean isLoading);
}
