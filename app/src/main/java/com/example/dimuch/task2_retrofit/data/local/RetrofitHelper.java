package com.example.dimuch.task2_retrofit.data.local;

import com.example.dimuch.task2_retrofit.data.model.PrivatBankApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class RetrofitHelper {

	private static PrivatBankApi privatBankApi;
	private static Retrofit retrofit;
	private static String baseUrl = "https://api.privatbank.ua/";

	public static PrivatBankApi getApi() {
		if (privatBankApi == null) {

			retrofit = new Retrofit.Builder()
					.baseUrl(baseUrl) //Базовая часть адреса
					.addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
					.addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
					.build();
			privatBankApi = retrofit.create(PrivatBankApi.class);

		}
		return privatBankApi;
	}
}