package com.example.day3;

import com.example.day3.bean.AllData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String Api ="https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/3")
    Observable<AllData> getData();
}
