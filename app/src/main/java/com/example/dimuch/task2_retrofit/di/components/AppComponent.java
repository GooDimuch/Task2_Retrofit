package com.example.dimuch.task2_retrofit.di.components;

import com.example.dimuch.task2_retrofit.di.modules.AppModule;
import com.example.dimuch.task2_retrofit.feature.weather.presenters.WeatherActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules = AppModule.class) @Singleton public interface AppComponent {

  void inject(WeatherActivityPresenter weatherActivityPresenter);
}