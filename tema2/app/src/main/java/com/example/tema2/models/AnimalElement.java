package com.example.tema2.models;

public class AnimalElement {
    private final String name;
    private final String continent;

    public AnimalElement(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }
}
