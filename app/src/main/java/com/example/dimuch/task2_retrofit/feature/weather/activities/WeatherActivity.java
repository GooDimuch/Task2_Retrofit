package com.example.dimuch.task2_retrofit.feature.weather.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task2_retrofit.R;
import com.example.dimuch.task2_retrofit.data.model.privatbank.SalesRateModel;
import com.example.dimuch.task2_retrofit.feature.weather.adapters.WeatherAdapter;
import com.example.dimuch.task2_retrofit.feature.weather.presenters.WeatherActivityPresenter;
import com.example.dimuch.task2_retrofit.feature.weather.views.IWeatherActivityView;
import com.example.dimuch.task2_retrofit.utils.Constants;
import java.util.List;

public class WeatherActivity extends MvpAppCompatActivity implements IWeatherActivityView {

  @BindView(R.id.pbLoading) ProgressBar pbLoading;
  @BindView(R.id.tvLoadingMessage) TextView tvLoadingMessage;
  @BindView(R.id.tvResultPost) TextView tvResultPost;

  @InjectPresenter WeatherActivityPresenter weatherActivityPresenter;

  private RecyclerView recyclerView;
  private List<SalesRateModel> exchangeRatesArray;
  private WeatherAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    //        exchangeRatesArray = new ArrayList<>();

    //        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
    //        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    //        recyclerView.setLayoutManager(layoutManager);

    //        adapter = new WeatherAdapter();
    //        recyclerView.setAdapter(adapter);
  }

  @Override public void showResultPost(String sResultPost) {
    //        adapter.notifyDataSetChanged();
    tvResultPost.setText(sResultPost);
  }

  @Override public void showMessage(String sLoadingMessage) {
    tvLoadingMessage.setText(sLoadingMessage);
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }

  @Override public void toggleMessageLoading(boolean isLoading) {
    pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    tvLoadingMessage.setVisibility(isLoading ? View.VISIBLE : View.GONE);
  }
}