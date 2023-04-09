package com.example.tema1.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tema1.R;
import com.example.tema1.models.Animal;


public class SecondFragment extends Fragment {
    private static final String ARG_ANIMAL = "animal";
    private Animal animal;

    public SecondFragment() {}

    public static SecondFragment newInstance(Animal animal) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANIMAL, animal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animal = (Animal) getArguments().getSerializable(ARG_ANIMAL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView animal_name = view.findViewById(R.id.animal_name);
        TextView animal_continent = view.findViewById(R.id.animal_continent);
        animal_name.setText(animal.getName());
        animal_continent.setText(animal.getContinent());

        switch (animal.getContinent()){
            case "Europa":
                view.setBackgroundResource(R.color.green);
                break;
            case "Asia":
                view.setBackgroundResource(R.color.red);
                break;
            case "Africa":
                view.setBackgroundResource(R.color.yellow);
                break;
            case "America de Nord":
            case "America de Sud":
                view.setBackgroundResource(R.color.blue);
                break;
            case "Australia":
                view.setBackgroundResource(R.color.orange);
                break;
            default:
                view.setBackgroundResource(R.color.white);
                break;
        }
    }
}
