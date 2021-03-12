package com.example.weather_cuongtrinh;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER = "http://dataservice.accuweather.com/";
    String APIKEY = "8UCGVVk2tBk9IG0V9Sof6iw4HrlZwAfi";
    String URL = "forecasts/v1/hourly/12hour/353412?apikey=" + APIKEY + "&language=vi-vn&metric=true";
    @GET(URL)
    Call<List<Item>> GetListData();
}
