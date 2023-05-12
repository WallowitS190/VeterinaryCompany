package com.example.veterinarycompany.activities.pet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.veterinarycompany.MainActivity;
import com.example.veterinarycompany.R;
import com.example.veterinarycompany.activities.DefaultMainActivity;
import com.example.veterinarycompany.activities.client.ClientMainActivity;
import com.example.veterinarycompany.activities.client.ListClientActivity;
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
                goToListPets();
            }
        });
        binding.cardPetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPetCreate();
            }
        });
    }

    private void onPetCreate(){
        Intent intent = new Intent(this, CreatePetActivity.class);
        startActivity(intent);
    }

    private void goToListPets() {
        Intent intent = new Intent(this, ListPetActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1000054:
                Intent intentGoToMain = new Intent(this, DefaultMainActivity.class);
                startActivity(intentGoToMain);
                break;

            case 1000028:
                Intent intentGoToClients = new Intent(this, ClientMainActivity.class);
                startActivity(intentGoToClients);
                break;

            case 1000023:
                Intent intentGoToExit = new Intent(this, MainActivity.class);
                startActivity(intentGoToExit);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}