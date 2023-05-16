package com.example.tema2.database.tasks;

import android.os.AsyncTask;

import com.example.tema2.database.AnimalRepository;
import com.example.tema2.database.AnimalsDatabase;
import com.example.tema2.database.models.AnimalEntity;

public class InsertAnimal extends AsyncTask<AnimalEntity,Void,Void> {

    private AnimalsDatabase animalsDatabase;
    private AnimalRepository.OnSuccessListener listener;

    public InsertAnimal(AnimalsDatabase animalsDatabase, AnimalRepository.OnSuccessListener listener){
        this.animalsDatabase = animalsDatabase;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(AnimalEntity... animals) {
        animalsDatabase.animalDao().insert(animals[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onSuccess();
    }
}
