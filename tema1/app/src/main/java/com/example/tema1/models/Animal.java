package com.example.tema1.models;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String continent;

    public Animal(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

}
