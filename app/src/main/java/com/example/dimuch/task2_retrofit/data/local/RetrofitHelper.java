package com.example.dimuch.task2_retrofit.data.local;

import com.example.dimuch.task2_retrofit.data.model.privatbank.PrivatBankApi;

import com.example.dimuch.task2_retrofit.data.model.weather.WeatherApi;
import com.example.dimuch.task2_retrofit.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class RetrofitHelper {

	private static PrivatBankApi privatBankApi;
	private static WeatherApi weatherApi;
	private static Retrofit retrofit;

	public static PrivatBankApi getPrivatBankApi() {
		if (privatBankApi == null) {

			retrofit = new Retrofit.Builder()
					.baseUrl(Constants.PRIVATBANK_BASE_URL) //Базовая часть адреса
					.addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
					.addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
					.build();
			privatBankApi = retrofit.create(PrivatBankApi.class);

		}
		return privatBankApi;
	}

	public static WeatherApi getWeatherApi() {
		if (weatherApi == null) {

			retrofit = new Retrofit.Builder()
					.baseUrl(Constants.WEATHER_BASE_URL) //Базовая часть адреса
					.addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
					.addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
					.build();
			weatherApi = retrofit.create(WeatherApi.class);

		}
		return weatherApi;
	}
}