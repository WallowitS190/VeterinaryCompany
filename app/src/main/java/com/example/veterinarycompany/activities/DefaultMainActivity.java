package com.example.veterinarycompany.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.veterinarycompany.activities.client.ClientMainActivity;
import com.example.veterinarycompany.activities.pet.PetMainActivity;
import com.example.veterinarycompany.databinding.ActivityDefaultMainBinding;

public class DefaultMainActivity extends AppCompatActivity {

    ActivityDefaultMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDefaultMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardItemClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainClient();
            }
        });

        binding.cardItemPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainPet();
            }
        });
    }

    private void goToMainClient() {
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }

    private void goToMainPet() {
        Intent intent = new Intent(this, PetMainActivity.class);
        startActivity(intent);
    }
}