package com.example.veterinarycompany.activities.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.veterinarycompany.MainActivity;
import com.example.veterinarycompany.R;
import com.example.veterinarycompany.activities.DefaultMainActivity;
import com.example.veterinarycompany.activities.pet.PetMainActivity;
import com.example.veterinarycompany.databinding.ActivityClientMainBinding;


public class ClientMainActivity extends AppCompatActivity {

    ActivityClientMainBinding binding;
    MenuView menuView;

    public static int optionGoToMain;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.option_goToMain) {
            Intent intentGoToMain = new Intent(this, DefaultMainActivity.class);
            startActivity(intentGoToMain);
        } else if(item.getItemId() == R.id.option_goToPets) {
            Intent intentGoToClients = new Intent(this, PetMainActivity.class);
            startActivity(intentGoToClients);
        } else if(item.getItemId() == R.id.option_exit) {
            Intent intentGoToExit = new Intent(this, MainActivity.class);
            startActivity(intentGoToExit);
        }

        return super.onOptionsItemSelected(item);
    }

}