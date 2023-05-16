package com.example.tema2.database;

import android.os.Handler;

import com.example.tema2.ApplicationController;
import com.example.tema2.database.models.AnimalEntity;
import com.example.tema2.database.tasks.GetAllAnimals;
import com.example.tema2.database.tasks.InsertAnimal;
import com.example.tema2.database.tasks.UpdateAnimal;

import java.util.List;


public class AnimalRepository {
    public static interface OnSuccessListener {
        void onSuccess();
    }

    public static interface OnGetAnimalsListerner {
        void onSuccess(List<AnimalEntity> animals);
    }

    private static AnimalsDatabase animalsDatabase;

    public AnimalRepository() {
        animalsDatabase = ApplicationController.getToDoDataBase();
    }

    public static void insertAnimal(AnimalEntity animal, OnSuccessListener listener) {
        new InsertAnimal(animalsDatabase, listener).execute(animal);
    }

    public void getAllAnimals(OnGetAnimalsListerner listener) {
        new GetAllAnimals(animalsDatabase, listener).execute();
    }

    public void updateAnimal(AnimalEntity animal, OnSuccessListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new UpdateAnimal(animalsDatabase, listener).execute(animal);
            }
        }, 5000);
        new UpdateAnimal(animalsDatabase, listener).execute(animal);
    }

}
