package com.example.tema2.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.tema2.models.AnimalElement;

@Entity(tableName = "animal_table")
public class AnimalEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String name;

    @ColumnInfo(name = "description")
    public String continent;

    public AnimalEntity(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public AnimalElement convert() {
        return new AnimalElement(name, continent);
    }
}
