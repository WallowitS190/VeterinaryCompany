package com.example.veterinarycompany.activities.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.databinding.ActivityPetMainBinding;

public class PetMainActivity extends AppCompatActivity {

    ActivityPetMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_main);

        binding = ActivityPetMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardPetList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.cardPetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}