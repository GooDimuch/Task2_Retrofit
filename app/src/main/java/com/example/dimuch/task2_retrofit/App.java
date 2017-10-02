package com.example.dimuch.task2_retrofit;

import android.app.Application;
import com.example.dimuch.task2_retrofit.di.components.AppComponent;
import com.example.dimuch.task2_retrofit.di.components.DaggerAppComponent;
import com.example.dimuch.task2_retrofit.di.modules.AppModule;

public class App extends Application {

  public static AppComponent getComponent() {
    return component;
  }

  private static AppComponent component;

  @Override public void onCreate() {
    super.onCreate();
    component = buildComponent();
  }

  private AppComponent buildComponent() {
    return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }
}