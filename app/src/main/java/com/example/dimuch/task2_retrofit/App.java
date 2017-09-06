package com.example.dimuch.task2_retrofit;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static UmoriliApi umoriliApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.umori.li/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static UmoriliApi getApi() {
        return umoriliApi;
    }
}