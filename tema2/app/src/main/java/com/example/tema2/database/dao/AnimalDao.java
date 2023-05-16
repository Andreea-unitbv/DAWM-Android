package com.example.tema2.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tema2.database.models.AnimalEntity;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AnimalEntity animal);

    @Update
    void update(AnimalEntity animal);

    @Delete
    void delete(AnimalEntity animal);

    @Query("SELECT * FROM animal_table")
    List<AnimalEntity> getAllAnimals();
}
