package com.nikolas.animalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalInfo extends AppCompatActivity {

    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        img = findViewById(R.id.image);
        txt = findViewById(R.id.animal);

        Intent intent = getIntent();

        img.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_foreground));
        txt.setText("Hi");

        String name = intent.getStringExtra("name");

        switch(name) {
            case "Dolphin":
                txt.setText("There are currently 42 species of dolphins and seven species of porpoises.");
                break;

            case "Lion":
                txt.setText("Lions are apex predators, which means they are at the top of the food chain.");
                break;

            case "Owl":
                txt.setText("Owls can rotate their necks 270 degrees.");
                break;

            case "Parrot":
                txt.setText("African grey parrots, known for their intelligence, have been observed using tools.");
                break;

            case "Rabbit":
                txt.setText("Rabbits are very social creatures that live in groups and dig underground warrens.");
                break;

            case "Tiger":
                txt.setText("Tigers can run up to 65km/h, jump over 5m, and swim well.");
                break;

            case "Turtle":
                txt.setText("Turtles have existed for around 215 million years, dating back to the time of the dinosaurs.");
                break;

            case "Wolf":
                txt.setText("Wolves run on their toes, which helps them to stop and turn quickly and to prevent their paw pads from wearing down.");
                break;
        }

    }
}
