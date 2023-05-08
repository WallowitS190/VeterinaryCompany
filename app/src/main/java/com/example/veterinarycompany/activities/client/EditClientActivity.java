package com.example.veterinarycompany.activities.client;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.classes.Client;
import com.example.veterinarycompany.db.DbClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditClientActivity extends AppCompatActivity {

    EditText txtName, txtLastName, txtPhone, txtAddress, txtBirtday;
    Button btnSave;

    FloatingActionButton edit, delete;

    boolean correct;

    Client client;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_client);

        txtName = findViewById(R.id.input_names);
        txtLastName = findViewById(R.id.input_lastNames);
        txtPhone = findViewById(R.id.input_phone);
        txtAddress = findViewById(R.id.input_address);
        txtBirtday = findViewById(R.id.input_birthday);
        btnSave = findViewById(R.id.btn_create);
        edit = findViewById(R.id.edit_client);
        edit.setVisibility(View.INVISIBLE);
        delete = findViewById(R.id.delete_client);
        delete.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbClient dbClient = new DbClient(EditClientActivity.this);
        client = dbClient.watchClient(id);

        if(client != null){
            txtName.setText(client.getNames());
            txtLastName.setText(client.getLastNames());
            txtAddress.setText(client.getAddress());
            txtPhone.setText(client.getPhone());
            txtBirtday.setText(client.getBirthday());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtName.getText().toString().equals("") && !txtLastName.getText().toString().equals("") && !txtAddress.getText().toString().equals("")
                        && !txtPhone.getText().toString().equals("") && !txtBirtday.getText().toString().equals("")){
                    correct = dbClient.editClient(id, txtName.getText().toString(),txtLastName.getText().toString(),txtAddress.getText().toString(),
                            txtPhone.getText().toString(),txtBirtday.getText().toString());

                    if(correct){
                        Toast.makeText(EditClientActivity.this, "CLIENT EDITED", Toast.LENGTH_SHORT).show();
                        watchRegister();
                    } else {
                        Toast.makeText(EditClientActivity.this, "CLIENT NOT EDITED", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditClientActivity.this, "IS NECESARY EDIT ALL INPUTS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void watchRegister(){
        Intent intent = new Intent(this, WatchClientActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}
