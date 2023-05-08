package com.example.veterinarycompany.activities.client;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.classes.Client;
import com.example.veterinarycompany.db.DbClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WatchClientActivity extends AppCompatActivity {

    EditText txtName, txtLastName, txtPhone, txtAddress, txtBirtday;
    Button btnSave;

    FloatingActionButton edit, delete;

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
        delete = findViewById(R.id.delete_client);

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

        DbClient dbClient = new DbClient(WatchClientActivity.this);
        client = dbClient.watchClient(id);

        if(client != null){
            txtName.setText(client.getNames());
            txtLastName.setText(client.getLastNames());
            txtAddress.setText(client.getAddress());
            txtPhone.setText(client.getPhone());
            txtBirtday.setText(client.getBirthday());

            btnSave.setVisibility(View.INVISIBLE);

            txtName.setInputType(InputType.TYPE_NULL);
            txtLastName.setInputType(InputType.TYPE_NULL);
            txtAddress.setInputType(InputType.TYPE_NULL);
            txtPhone.setInputType(InputType.TYPE_NULL);
            txtBirtday.setInputType(InputType.TYPE_NULL);
        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WatchClientActivity.this, EditClientActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WatchClientActivity.this);
                builder.setMessage("¿Do you remove this client?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean correct = dbClient.deleteClient(id);

                        if (correct){
                            list();
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });

    }

    private void list(){
        Intent intent = new Intent(this, ClientMainActivity.class);
        startActivity(intent);
    }
}