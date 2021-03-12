package com.example.weather_cuongtrinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    TextView tvIconPhrase, tvTemperature;

    List<Item> list = new ArrayList<>();
    HomeAdapter adapter;
    RecyclerView rvTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvTemperature = findViewById(R.id.tvTemperature);
        tvIconPhrase = findViewById(R.id.tvIconPhrase);


        //B1: Data Source
        getListData();

        //B2: Adapter
        adapter = new HomeAdapter(this, list);

        //B3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        //B4 Recycler View
        rvTemperature = findViewById(R.id.rvListTemperature);
        rvTemperature.setLayoutManager(layoutManager);
        rvTemperature.setAdapter(adapter);
    }

    private void getListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.GetListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(response.body() != null){
                    list = response.body();
                    firstData(list.get(0));
                    adapter.reloadData(list);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }

    private void firstData(Item data)  {
        if (data != null) {
            String temperature = data.getTemperature().getValue().toString() + " °C";
            tvIconPhrase.setText(data.getIconPhrase());
            tvTemperature.setText(temperature);
        }
    }
}