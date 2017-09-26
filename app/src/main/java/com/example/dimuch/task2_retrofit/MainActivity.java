package com.example.dimuch.task2_retrofit;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends MvpAppCompatActivity implements MyView {

    @InjectPresenter
            MyPresenter myPresenter;

    private RecyclerView recyclerView;
    private List<SalesRateModel> exchangeRatesArray;
    private ExchangeRatesAdapter adapter;

    private ProgressBar pbLoading;
    private TextView tvLoadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        tvLoadingMessage = (TextView) findViewById(R.id.tvLoadingMessage);


        exchangeRatesArray = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExchangeRatesAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void uploadResultPost() {
        RetrofitHelper.getApi().getData("01.12.2014")
                .map(SalesRateModel::toString)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addListNewsEntity);
    }

    @Override
    public void showResultPost() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String sLoadingMessage) {
        tvLoadingMessage.setText(sLoadingMessage);
    }

    @Override
    public void showToast(String sToastMessage) {
        Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void toggleMessageLoading(boolean isLoading) {
        pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        tvLoadingMessage.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }
}