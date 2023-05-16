package com.example.tema2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tema2.R;
import com.example.tema2.database.AnimalRepository;
import com.example.tema2.database.models.AnimalEntity;
import com.example.tema2.models.AnimalElement;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    private EditText nameEditText;
    private EditText continentEditText;
    private Button addButton;
    AnimalRepository animalRepository = new AnimalRepository();

    private ArrayList<AnimalElement> animals = null;

    private ArrayList<AnimalElement> getAnimals() {
        if (animals == null) {
            animals = new ArrayList<>();
        }
        return animals;
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1, container, false);

        // Find the views in the layout
        nameEditText = view.findViewById(R.id.nameOfAnAnimal);
        continentEditText = view.findViewById(R.id.continent);
        addButton = view.findViewById(R.id.addButton);

        // Set click listener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String continent = continentEditText.getText().toString().trim();

                if (name.isEmpty() || continent.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!isContinent(continent)) {
                    Toast.makeText(getContext(), "Please write a valid continent", Toast.LENGTH_SHORT).show();
                } else {
                    AnimalEntity animal = new AnimalEntity(name, continent);

                    animalRepository.insertAnimal(animal, new AnimalRepository.OnSuccessListener() {
                        @Override
                        public void onSuccess() {
                            getAnimals().add(animal.convert());

                            Toast.makeText(getContext(), "Success.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

    private boolean isContinent(String continent) {
        return continent.equals("Asia") ||
                continent.equals("Europe") ||
                continent.equals("Africa") ||
                continent.equals("North America") ||
                continent.equals("South America") ||
                continent.equals("Australia");
    }
}
