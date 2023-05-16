package com.example.tema2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tema2.R;
import com.example.tema2.models.AnimalElement;

import java.util.List;

public class AnimalItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<AnimalElement> animals;
    public AnimalItemAdapter(List<AnimalElement>animals){

        this.animals=animals;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AnimalElement animal = animals.get(position);
        ((AnimalViewHolder) holder).bind(animal);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {

        TextView animalNameTextView, animalContinentTextView;
        View separator;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            animalNameTextView = itemView.findViewById(R.id.animal_name);
            animalContinentTextView = itemView.findViewById(R.id.animal_continent);
            separator = itemView.findViewById(R.id.separator);
        }

        public void bind(AnimalElement animal) {
            animalNameTextView.setText(animal.getName());
            animalContinentTextView.setText(animal.getContinent());
        }
    }
}
