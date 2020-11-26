package com.example.cinemaapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseURL= "http://192.168.100.243/cinemapp/"; //localhost ip wenny
    private static Retrofit retro;

    public static Retrofit connectRetrofit() {
        if(retro==null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
