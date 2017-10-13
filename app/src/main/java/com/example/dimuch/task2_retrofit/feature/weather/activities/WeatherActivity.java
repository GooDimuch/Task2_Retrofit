package com.example.dimuch.task2_retrofit.feature.weather.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task2_retrofit.R;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherForWholeDay;
import com.example.dimuch.task2_retrofit.feature.weather.adapters.WeatherAdapter;
import com.example.dimuch.task2_retrofit.feature.weather.presenters.WeatherActivityPresenter;
import com.example.dimuch.task2_retrofit.feature.weather.views.IWeatherActivityView;
import java.util.List;
import timber.log.Timber;

public class WeatherActivity extends MvpAppCompatActivity implements IWeatherActivityView {

  @BindView(R.id.tvResultPost) TextView tvResultPost;
  @BindView(R.id.rvWeather) RecyclerView rvWeather;

  @InjectPresenter WeatherActivityPresenter weatherActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

  }

  @Override public void showResultPost(String sResultPost) {
    Timber.e("showResultPost");
    //        adapter.notifyDataSetChanged();
    tvResultPost.setText(sResultPost);
  }

  @Override public void showWeatherArray(List<WeatherForWholeDay> weatherArray) {
    rvWeather.setLayoutManager(new LinearLayoutManager(this));
    WeatherAdapter adapter = new WeatherAdapter(weatherArray);
    rvWeather.setAdapter(adapter);
  }

  @Override public void showToast(String sToastMessage) {
    Timber.e("showToast");
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }
}