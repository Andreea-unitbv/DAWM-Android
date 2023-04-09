package com.example.tema1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tema1.R;
import com.example.tema1.adapters.AnimalItemsAdapter;
import com.example.tema1.models.Animal;
import com.example.tema1.models.ListOfAnimals;


import java.util.List;



public class AnimalsFragment extends Fragment implements AnimalItemsAdapter.ItemClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.rv_animals);

        ListOfAnimals animalsExample=new ListOfAnimals();
        List<Animal> animals = animalsExample.animals;

        AnimalItemsAdapter adapter = new AnimalItemsAdapter(animals, this);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(layoutManager);


    }


    @Override
    public void OnItemClick(Animal animal) {
        Fragment fragment= SecondFragment.newInstance(animal);
        FragmentTransaction transaction= requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_animals,fragment,"fragment_second");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}