package com.example.tema2.database.tasks;

import android.os.AsyncTask;

import com.example.tema2.database.AnimalRepository;
import com.example.tema2.database.AnimalsDatabase;
import com.example.tema2.database.models.AnimalEntity;

import java.util.List;

public class GetAllAnimals extends AsyncTask<Void,Void,List<AnimalEntity>> {
    private AnimalsDatabase animalsDatabase;
    private AnimalRepository.OnGetAnimalsListerner listener;

    public GetAllAnimals(AnimalsDatabase animalsDatabase, AnimalRepository.OnGetAnimalsListerner listener){
        this.animalsDatabase = animalsDatabase;
        this.listener = listener;
    }

    @Override
    protected List<AnimalEntity> doInBackground(Void... voids) {
        return animalsDatabase.animalDao().getAllAnimals();
    }

    @Override
    protected void onPostExecute(List<AnimalEntity> items) {
        super.onPostExecute(items);
        listener.onSuccess(items);
    }
}
