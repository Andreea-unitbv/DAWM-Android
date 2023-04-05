package com.example.tema1.adapters;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tema1.R;
import com.example.tema1.models.Animal;

import java.util.List;

public class AnimalItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Animal> animals;

    public AnimalItemsAdapter(List<Animal>animals){
        this.animals=animals;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);

        AnimalViewHolder viewHolder = new AnimalViewHolder(view);

        Log.e("Adapter", "onCreateViewHolder movie");

        // Get screen height
        DisplayMetrics displayMetrics = parent.getContext().getResources().getDisplayMetrics();
        int screenHeight = displayMetrics.heightPixels;

        // Set cell height dynamically
        int cellHeight = screenHeight / 7; // Set cell height to 1/7 of screen height
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = cellHeight;
        view.setLayoutParams(params);


        return viewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Animal animalModel = animals.get(position);

        ((AnimalViewHolder)holder).bind(animalModel);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class AnimalViewHolder extends RecyclerView.ViewHolder {

        TextView animalNameTextView;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            animalNameTextView = itemView.findViewById(R.id.animal_name);
        }

        public void bind(Animal animal) {
            animalNameTextView.setText(animal.getName());
        }
    }
}
