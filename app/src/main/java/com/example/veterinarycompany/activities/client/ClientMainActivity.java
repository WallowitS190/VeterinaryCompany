package com.example.veterinarycompany.activities.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.veterinarycompany.MainActivity;
import com.example.veterinarycompany.activities.DefaultMainActivity;
import com.example.veterinarycompany.activities.pet.PetMainActivity;
import com.example.veterinarycompany.databinding.ActivityClientMainBinding;


public class ClientMainActivity extends AppCompatActivity {

    ActivityClientMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityClientMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardItemCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {goToCreateClient();}
        });

        binding.cardItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToListClients();
            }
        });
    }

    private void goToCreateClient() {
        Intent intent = new Intent(this, CreateClientActivity.class);
        startActivity(intent);
    }

    private void goToListClients() {
        Intent intent = new Intent(this, ListClientActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1000054:
                Intent intentGoToMain = new Intent(this, DefaultMainActivity.class);
                startActivity(intentGoToMain);
                break;

            case 1000053:
                Intent intentGoToClients = new Intent(this, PetMainActivity.class);
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