package com.example.todaynews;

import com.example.todaynews.Model.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Headlines> getHeadlines(
        @Query("country") String country,
        @Query("apiKey") String apiKey

        );
}
