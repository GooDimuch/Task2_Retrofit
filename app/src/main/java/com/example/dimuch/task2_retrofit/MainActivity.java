package com.example.dimuch.task2_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

//        try {
//            Response response = App.getApi().getData("bash", 100).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        App.getApi().getData("01.12.2014").enqueue(new Callback<SalesRateModel>() {
            @Override
            public void onResponse(Call<SalesRateModel> call, Response<SalesRateModel> response) {
                exchangeRatesArray.add(response.body());
//                    Toast.makeText(getApplicationContext(),
//                            String.valueOf(exchangeRatesArray.size()), Toast.LENGTH_LONG).show();
                Log.wtf("myLog", "post1: " + String.valueOf(exchangeRatesArray.size()));
                adapter.addListNewsEntity(exchangeRatesArray);
            }

            @Override
            public void onFailure(Call<SalesRateModel> call, Throwable t) {

            }
        });
    }
}