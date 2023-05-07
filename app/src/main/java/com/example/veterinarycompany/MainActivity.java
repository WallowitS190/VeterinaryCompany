package com.example.veterinarycompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.veterinarycompany.activities.DefaultMainActivity;
import com.example.veterinarycompany.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateLogin();
            }
        });

    }

    private void validateLogin() {

        String inputUsername = binding.inputUsername.getText().toString();
        String inputPassword = binding.inputPassword.getText().toString();
        CheckBox chkTermsAndConditions = binding.chkTermsAndConditions;

        if(inputUsername.equals("") && inputPassword.equals("")) {
            Toast.makeText(this, "Digite las credenciales", Toast.LENGTH_SHORT).show();
        } else {
            if(!chkTermsAndConditions.isChecked()) {
                Toast.makeText(this, "Debe aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show();
            } else if(inputUsername.equals("Admin") && inputPassword.equals("123")) {
                goToPrincipal();
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void goToPrincipal() {
        Intent intent = new Intent(this, DefaultMainActivity.class);
        startActivity(intent);
    }

}