package com.example.jva_practice.util;

import com.example.jva_practice.api.APIService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager instance;

    public static RetrofitManager getInstance() {
        if (instance == null) {
            instance = new RetrofitManager();
        }
        return instance;
    }

    private  APIService myAPIService;

    private RetrofitManager() {


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
        // 設置baseUrl即要連的網站，addConverterFactory用Gson作為資料處理Converter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        myAPIService = retrofit.create(APIService.class);
    }


    public APIService  getAPI() {
        return myAPIService;
    }

}
