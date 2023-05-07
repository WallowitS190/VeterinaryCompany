package com.example.veterinarycompany.activities.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.veterinarycompany.databinding.ActivityCreateClientBinding;
import com.example.veterinarycompany.db.DbClient;
import com.example.veterinarycompany.db.DbHelper;

public class CreateClientActivity extends AppCompatActivity {

    ActivityCreateClientBinding binding;

    DbHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateClientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createClient();
            }
        });
    }

    private void createClient() {

        String names = binding.inputNames.getText().toString();
        String lastNames = binding.inputLastNames.getText().toString();
        String birthday = binding.inputBirthday.getText().toString();
        String address = binding.inputAddress.getText().toString();
        String phone = binding.inputPhone.getText().toString();

        DbClient dbClient = new DbClient(this);
        long id = dbClient.insertClient(names, lastNames, birthday, address, phone);

        if(id > 0) {
            Toast.makeText(this, "Registro insertado correctamente", Toast.LENGTH_SHORT).show();
            clearInputs();
            goToClientMain();
        } else {
            Toast.makeText(this, "No se pudo insertar el registro", Toast.LENGTH_SHORT).show();
        }

    }

    private void clearInputs() {
        binding.inputNames.setText("");
        binding.inputLastNames.setText("");
        binding.inputBirthday.setText("");
        binding.inputAddress.setText("");
        binding.inputPhone.setText("");
    }

    private void goToClientMain() {
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }
}