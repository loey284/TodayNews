package com.example.cinemaapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cinemaapp.API.APIRequestData;
import com.example.cinemaapp.API.RetroServer;
import com.example.cinemaapp.Adapter.AdapterFilm;
import com.example.cinemaapp.Model.DataModel;
import com.example.cinemaapp.Model.ResponseModel;
import com.example.cinemaapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieList extends AppCompatActivity {
    private RecyclerView recyclerView_film;
    private RecyclerView.Adapter adapterData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listFilm = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView_film = findViewById(R.id.recyclerView_film);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView_film.setLayoutManager(lmData);

        retrieveData();
    }

    public void retrieveData(){
        APIRequestData ardData = RetroServer.connectRetrofit().create(APIRequestData.class);
        Call<ResponseModel> viewData = ardData.ardRetrieveData();

        viewData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int code = response.body().getCode();
                String message = response.body().getMessage();

                Toast.makeText(MovieList.this, "Code : "+code+" | Message : "+message, Toast.LENGTH_SHORT).show();

                listFilm = response.body().getData();

                adapterData = new AdapterFilm(MovieList.this, listFilm);
                recyclerView_film.setAdapter(adapterData);
                adapterData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MovieList.this, "Failed to Connect Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}