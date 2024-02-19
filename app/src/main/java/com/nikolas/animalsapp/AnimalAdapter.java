package com.nikolas.animalsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context, MyClickInterface myClickInterface) {
        this.animalData = animalData;
        this.context = context;
        this.myClickInterface = myClickInterface;
    }

    @NonNull
    @Override
    //When you scroll down the rows above will be deleted to save memory.
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    //When you scroll back up the rows will reappear. This also makes the image and text to what specific animal we want.
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.txtAnimalName.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animalData.size();
    }

    //Inner class
    class AnimalRowHolder extends RecyclerView.ViewHolder {

        TextView txtAnimalName;
        ImageView imgAnimal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            //in this case android doesn't know we are in the main activity, so we need to use itemView.findViewById()
            //We want to look for the text view inside the itemView parameter
            txtAnimalName = itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = itemView.findViewById(R.id.img_animal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });

        }



    }


    interface MyClickInterface {
        void onItemClick(int positionOfTheAnimal);
    }

}
