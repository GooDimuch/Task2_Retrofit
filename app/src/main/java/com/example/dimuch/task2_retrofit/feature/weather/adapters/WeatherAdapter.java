package com.example.dimuch.task2_retrofit.feature.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.dimuch.task2_retrofit.R;
import com.example.dimuch.task2_retrofit.data.model.weather.WeatherDay;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

  private List<WeatherDay> mWeatherArray;

  public WeatherAdapter(List<WeatherDay> weatherArray) {
    mWeatherArray = weatherArray;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    WeatherDay weatherDay = mWeatherArray.get(position);

    if (position == 0) {
      holder.tvDayOfWeek.setText("Today");
    } else if (position == 1) {
      holder.tvDayOfWeek.setText("Tomorrow");
    } else {
      holder.tvDayOfWeek.setText(weatherDay.getDayOfWeek());
    }
    holder.ivWeatherIcon.setImageResource(weatherDay.getWeatherIcon());
    holder.tvWeatherOfDay.setText(weatherDay.getWeatherOfDay());
    holder.tvTemperature.setText(weatherDay.getTemperatureOfDay());
  }

  @Override public int getItemCount() {
    return mWeatherArray == null ? 0 : mWeatherArray.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvDayOfWeek) TextView tvDayOfWeek;
    @BindView(R.id.ivWeatherIcon) ImageView ivWeatherIcon;
    @BindView(R.id.tvWeatherOfDay) TextView tvWeatherOfDay;
    @BindView(R.id.tvTemperature) TextView tvTemperature;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public void addListNewsEntity(List<WeatherDay> weatherArray) {
    this.mWeatherArray = weatherArray;
    //        notifyDataSetChanged();
  }
}