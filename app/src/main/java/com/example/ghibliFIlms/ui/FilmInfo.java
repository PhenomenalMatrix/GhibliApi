package com.example.ghibliFIlms.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a32work.R;
import com.example.ghibliFIlms.App;
import com.example.ghibliFIlms.data.models.FilmModel;
import com.example.ghibliFIlms.data.network.GhibliService;

public class FilmInfo extends AppCompatActivity {

    TextView director, date, desc;
    String position;
    Button close;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);

        director = findViewById(R.id.FilmInfoAC_director_tv);
        date = findViewById(R.id.FilmInfoAC_date_tv);
        desc = findViewById(R.id.FilmInfoAC_desc_tv);
        close = findViewById(R.id.FilmInfoACT_close_btn);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (getIntent() != null) {
            position = getIntent().getStringExtra("key");
        }

        App.ghibliService.getFilmById(position, new GhibliService.GhibliFilmCallback() {
            @Override
            public void onSuccess(FilmModel filmModel) {
                director.setText(filmModel.getDirector());
                date.setText(filmModel.getReleaseDate());
                desc.setText(filmModel.getDescription());
            }

            @Override
            public void onFailure(Throwable ex) {


            }
        });
    }
}