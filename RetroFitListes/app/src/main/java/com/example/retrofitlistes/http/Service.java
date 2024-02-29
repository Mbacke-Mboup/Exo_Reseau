package com.example.retrofitlistes.http;

import com.example.retrofitlistes.Transfer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/exos/long/list")
    Call<List<String>> webOne();

    @GET("/exos/truc/list")
    Call<List<Transfer>> webTwo();
}
