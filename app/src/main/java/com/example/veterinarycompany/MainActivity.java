package com.example.veterinarycompany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nombre,apellido,direccion,telefono,nacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.ingresaNombre);
        apellido = findViewById(R.id.ingresaapellido);
        direccion = findViewById(R.id.ingresadireccion);
        telefono = findViewById(R.id.ingresatelefono);
        nacimiento = findViewById(R.id.ingresafecha);


    }
}