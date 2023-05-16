package com.example.tema2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tema2.database.dao.AnimalDao;
import com.example.tema2.database.models.AnimalEntity;

@Database(entities = {AnimalEntity.class}, version = 1)
public abstract class AnimalsDatabase extends RoomDatabase {

    public abstract AnimalDao animalDao();

}
