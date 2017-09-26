package com.example.dimuch.task2_retrofit;

import android.app.Application;


public class App extends Application {

//    private static PrivatBankApi privatBankApi;

    @Override
    public void onCreate() {
        super.onCreate();

//        privatBankApi = RetrofitHelper.getApi(); //Создаем объект, при помощи которого будем выполнять запросы
    }

//    public static PrivatBankApi getApi() {
//        return privatBankApi;
//    }
}