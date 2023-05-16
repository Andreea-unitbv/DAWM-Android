package com.example.tema2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tema2.R;
import com.example.tema2.adapters.AnimalItemAdapter;
import com.example.tema2.database.AnimalRepository;
import com.example.tema2.database.models.AnimalEntity;
import com.example.tema2.models.AnimalElement;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    AnimalRepository animalRepository = new AnimalRepository();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.rv_animals);

        List<AnimalElement> animals = new ArrayList<>();
        animalRepository.getAllAnimals(new AnimalRepository.OnGetAnimalsListerner() {
            @Override
            public void onSuccess(List<AnimalEntity> animals) {
                animals.clear();
                animals.addAll(animals);
                //adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Success.", Toast.LENGTH_SHORT).show();
            }
        });

        AnimalItemAdapter adapter = new AnimalItemAdapter(animals);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

}