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

        if(item.getItemId() == R.id.option_goToMain) {
            Intent intentGoToMain = new Intent(this, DefaultMainActivity.class);
            startActivity(intentGoToMain);
        } else if(item.getItemId() == R.id.option_goToClients) {
            Intent intentGoToClients = new Intent(this, ClientMainActivity.class);
            startActivity(intentGoToClients);
        } else if(item.getItemId() == R.id.option_exit) {
            Intent intentGoToExit = new Intent(this, MainActivity.class);
            startActivity(intentGoToExit);
        }
        return super.onOptionsItemSelected(item);
    }
}