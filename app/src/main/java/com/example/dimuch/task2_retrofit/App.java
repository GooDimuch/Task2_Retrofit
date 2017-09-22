package com.example.dimuch.task2_retrofit;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static PrivatBankApi privatBankApi;
    private static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/") //Базовая часть адреса
//                .baseUrl("http://umorili.herokuapp.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
    }

    public static PrivatBankApi getApi() {
        privatBankApi = retrofit.create(PrivatBankApi.class); //Создаем объект, при помощи которого будем выполнять запросы
        return privatBankApi;
    }
}