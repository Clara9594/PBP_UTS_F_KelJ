package com.example.tugasbesar_pbp_f;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //jgn lupa ganti BASE URL
    public static final String BASE_URL = "https://cardido.masuk.web.id/public/api/";
    public static Retrofit retrofit = null;
//    public static Gson gson = new GsonBuilder()
//            .setLenient()
//            .create();
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
