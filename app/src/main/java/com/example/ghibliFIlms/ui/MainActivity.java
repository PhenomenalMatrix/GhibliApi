package com.example.ghibliFIlms.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;


import com.example.a32work.R;
import com.example.ghibliFIlms.App;
import com.example.ghibliFIlms.adapter.FilmAdapter;
import com.example.ghibliFIlms.data.models.FilmModel;
import com.example.ghibliFIlms.data.network.GhibliService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FilmModel> films = new ArrayList<>();
    RecyclerView recyclerView;
    FilmAdapter filmAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        filmAdapter = new FilmAdapter();
        recyclerView.setAdapter(filmAdapter);



        App.ghibliService.getFilms(new GhibliService.GhibliListCallBack() {
            @Override
            public void onSuccess(ArrayList<FilmModel> filmModels) {
                filmAdapter.SetFilmModel(filmModels);
                filmAdapter.setOnclick(new FilmAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent = new Intent(MainActivity.this, FilmInfo.class);
                        intent.putExtra("key", filmModels.get(position).getId());
                        startActivity(intent);
                    }


                });
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }
}
