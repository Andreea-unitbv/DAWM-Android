package com.example.tema1.adapters;

import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tema1.R;
import com.example.tema1.models.Animal;

import java.util.List;

public class AnimalItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Animal> animals;
    private final ItemClickListener clickListener;
    public AnimalItemsAdapter(List<Animal>animals,ItemClickListener clickListener){

        this.animals=animals;
        this.clickListener=clickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if(animals.get(position).getContinent().equals("Asia"))
            return 1;
        return 0;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType==1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal_h, parent, false);
            return new AnimalViewHolderHorizontal(view);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal_v, parent, false);
            return new AnimalViewHolderVertical(view);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Animal animal = animals.get(position);
        holder.itemView.setOnClickListener(view -> clickListener.OnItemClick(animal));
        int color;
        if(animal.getContinent().equals("Asia")){
            ((AnimalViewHolderHorizontal) holder).bind(animal);

            color =holder.itemView.getContext().getColor(R.color.red);
            ((AnimalViewHolderHorizontal)holder).animalNameTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            ((AnimalViewHolderHorizontal) holder).animalContinentTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        }

        else {
            ((AnimalViewHolderVertical) holder).bind(animal);
            switch (animal.getContinent()) {
                case "Europa":
                    color = holder.itemView.getContext().getColor(R.color.green);
                    break;
                case "Africa":
                    color = holder.itemView.getContext().getColor(R.color.yellow);
                    ((AnimalViewHolderVertical) holder).animalContinentTextView.setGravity(Gravity.END);
                    ((AnimalViewHolderVertical) holder).separator.setVisibility(View.VISIBLE);
                    break;
                case "America de Nord":
                case "America de Sud":
                    color = holder.itemView.getContext().getColor(R.color.blue);
                    ((AnimalViewHolderVertical) holder).animalNameTextView.setGravity(Gravity.END);
                    ((AnimalViewHolderVertical) holder).animalContinentTextView.setGravity(Gravity.END);
                    break;
                case "Australia":
                    color = holder.itemView.getContext().getColor(R.color.orange);
                    ((AnimalViewHolderVertical) holder).animalNameTextView.setGravity(Gravity.CENTER);
                    ((AnimalViewHolderVertical) holder).animalContinentTextView.setGravity(Gravity.CENTER);
                    break;
                default:
                    color = holder.itemView.getContext().getColor(R.color.white);
                    break;
            }
        }

        holder.itemView.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    static class AnimalViewHolderVertical extends RecyclerView.ViewHolder {

        TextView animalNameTextView, animalContinentTextView;
        View separator;

        public AnimalViewHolderVertical(@NonNull View itemView) {
            super(itemView);

            animalNameTextView = itemView.findViewById(R.id.animal_name_v);
            animalContinentTextView = itemView.findViewById(R.id.animal_continent_v);
            separator = itemView.findViewById(R.id.separator_v);
        }

        public void bind(Animal animal) {
            animalNameTextView.setText(animal.getName());
            animalContinentTextView.setText(animal.getContinent());
        }
    }


    static class AnimalViewHolderHorizontal extends RecyclerView.ViewHolder {

        TextView animalNameTextView, animalContinentTextView;
        View separator;
        public AnimalViewHolderHorizontal(@NonNull View itemView) {
            super(itemView);

            animalNameTextView = itemView.findViewById(R.id.animal_name_h);
            animalContinentTextView = itemView.findViewById(R.id.animal_continent_h);
            separator = itemView.findViewById(R.id.separator_h);
        }

        public void bind(Animal animal) {
            animalNameTextView.setText(animal.getName());
            animalContinentTextView.setText(animal.getContinent());
        }
    }

    public interface ItemClickListener{
         void OnItemClick(Animal animal);
    }
}
