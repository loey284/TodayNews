package com.example.cinemaapp.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.Model.DataModel;
import com.example.cinemaapp.R;

import java.util.List;

public class AdapterFilm extends RecyclerView.Adapter<AdapterFilm.HolderData> {
    private Context ctx;
    private List<DataModel> listFilm;

    public AdapterFilm(Context ctx, List<DataModel> listFilm) {
        this.ctx = ctx;
        this.listFilm = listFilm;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listFilm.get(position);

        holder.tv_id.setText(String.valueOf(dm.getId()));
        holder.tv_title.setText(dm.getTitle());
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tv_title, tv_id;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.filmTitle);
            tv_id = itemView.findViewById(R.id.filmId);
        }
    }
}
