package com.example.veterinarycompany.activities.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

}