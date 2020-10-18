package com.example.ghibliFIlms;

import android.app.Application;

import com.example.ghibliFIlms.data.network.GhibliService;

public class App extends Application {


    public static GhibliService ghibliService;

    @Override
    public void onCreate() {
        super.onCreate();

        ghibliService = new GhibliService();

    }
}
