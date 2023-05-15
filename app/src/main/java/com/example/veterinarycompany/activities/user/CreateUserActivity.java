package com.example.veterinarycompany.activities.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.veterinarycompany.MainActivity;
import com.example.veterinarycompany.databinding.ActivityCreateUserBinding;
import com.example.veterinarycompany.db.DbHelper;
import com.example.veterinarycompany.db.DbUser;

public class CreateUserActivity extends AppCompatActivity {

    ActivityCreateUserBinding binding;
    DbHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser() {

        String names = binding.inputNames.getText().toString();
        String username = binding.inputUsername.getText().toString();
        String password = binding.inputPassword.getText().toString();

        DbUser dbUser = new DbUser(this);
        long id = dbUser.insertUser(names, username, password);

        if(id > 0) {
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
            goToMain();
        } else {
            Toast.makeText(this, "No se pudo insertar el registro", Toast.LENGTH_SHORT).show();
        }

    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}