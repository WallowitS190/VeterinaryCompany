package com.example.veterinarycompany.activities.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.activities.client.ClientMainActivity;
import com.example.veterinarycompany.activities.client.ListClientActivity;
import com.example.veterinarycompany.adaptadores.ListClientAdapter;
import com.example.veterinarycompany.classes.Client;
import com.example.veterinarycompany.databinding.ActivityCreatePetBinding;
import com.example.veterinarycompany.db.DbClient;
import com.example.veterinarycompany.db.DbHelper;
import com.example.veterinarycompany.db.DbPet;

import java.util.ArrayList;

public class CreatePetActivity extends AppCompatActivity {

    ActivityCreatePetBinding binding;

    ArrayAdapter<String> listArrayClients;

    DbHelper dbHelper;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pet);

        binding = ActivityCreatePetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Realiza una consulta para obtener los datos
        String[] projection = {"names"};
        Cursor cursor = db.query("t_client", projection, null, null, null, null, null);

        // Crea una lista de opciones para la lista desplegable
        ArrayList<String> opciones = new ArrayList<String>();
        while(cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow("names"));
            opciones.add(nombre);
        }
        cursor.close();

        DbClient dbClient = new DbClient(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.input_owner);
        spinner.setAdapter(adapter);

        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPet();
            }
        });
    }

    private void createPet(){



        String name = binding.inputName.getText().toString();
        int age = Integer.parseInt(binding.inputAge.getText().toString());
        String race = binding.inputRace.getText().toString();
        String sex = binding.inputSex.getText().toString();
        //int id_owner = Integer.parseInt(binding.inputOwner.getText().toString());

        DbPet dbPet = new DbPet(this);
        long id = dbPet.insertPet(name, age, race, sex, 11);

        if(id > 0) {
            Toast.makeText(this, "Registro insertado correctamente", Toast.LENGTH_SHORT).show();
            clearInputs();
            goToPetMain();
        } else {
            Toast.makeText(this, "No se pudo insertar el registro", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearInputs() {
        binding.inputName.setText("");
        binding.inputAge.setText("");
        binding.inputRace.setText("");
        binding.inputSex.setText("");
        //binding.inputOwner.setText("");
    }

    private void goToPetMain() {
        Intent intent = new Intent(this, PetMainActivity.class);
        startActivity(intent);
    }

}