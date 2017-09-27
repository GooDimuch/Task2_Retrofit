package com.example.dimuch.task2_retrofit.feature.weather.adapters;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.dimuch.task2_retrofit.R;
import com.example.dimuch.task2_retrofit.utils.Constants;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

  private List<String> exchangeRatesArray;

  public WeatherAdapter() {

  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    String post = exchangeRatesArray.get(position);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      holder.exchangeRate.setText(Html.fromHtml(post.toString(), Html.FROM_HTML_MODE_LEGACY));
    } else {
      holder.exchangeRate.setText(Html.fromHtml(post.toString()));
    }
    holder.bank.setText("test");
  }

  @Override public int getItemCount() {
    if (exchangeRatesArray == null) return 0;
    return exchangeRatesArray.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    TextView exchangeRate;
    TextView bank;

    public ViewHolder(View itemView) {
      super(itemView);
      exchangeRate = (TextView) itemView.findViewById(R.id.exchangeRate);
      bank = (TextView) itemView.findViewById(R.id.bank);
    }
  }

  public void addListNewsEntity(List<String> strings) {
    Log.wtf(Constants.MY_LOG, "addListNewsEntity()");
    this.exchangeRatesArray = strings;
    //        notifyDataSetChanged();
  }
}