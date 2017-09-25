package com.example.dimuch.task2_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<SalesRateModel> exchangeRatesArray;
    private ExchangeRatesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exchangeRatesArray = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExchangeRatesAdapter();
        recyclerView.setAdapter(adapter);

//        App.getApi().getData("01.12.2014").enqueue(new Callback<SalesRateModel>() {
//            @Override
//            public void onResponse(Call<SalesRateModel> call, Response<SalesRateModel> response) {
//
//                exchangeRatesArray.add(response.body());
////                    Toast.makeText(getApplicationContext(),
////                            String.valueOf(exchangeRatesArray.size()), Toast.LENGTH_LONG).show();
//                Log.wtf("myLog", "post1: " + String.valueOf(exchangeRatesArray.size()));
//                adapter.addListNewsEntity(exchangeRatesArray);
//            }
//
//            @Override
//            public void onFailure(Call<SalesRateModel> call, Throwable t) {
//
//            }
//        });

        App.getApi().getData("01.12.2014")
                .map(SalesRateModel::toString)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addListNewsEntity);
    }
}