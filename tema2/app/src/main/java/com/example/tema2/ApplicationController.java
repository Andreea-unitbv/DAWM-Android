package com.example.tema2;

import android.app.Application;

import androidx.room.Room;

import com.example.tema2.database.AnimalsDatabase;

public class ApplicationController extends Application {
    private static ApplicationController instance;
    private static AnimalsDatabase animalsDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setupDataBase();
    }

    private void setupDataBase() {
        String animalsDataBaseName = "AnimalsDB";

        animalsDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        AnimalsDatabase.class,
                        animalsDataBaseName)
                .build();
    }

    public static AnimalsDatabase getToDoDataBase() {
        return animalsDatabase;
    }

    public static ApplicationController getInstance() {
        return instance;
    }
}
