package com.example.veterinarycompany.activities.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.adaptadores.ListClientAdapter;
import com.example.veterinarycompany.classes.Client;
import com.example.veterinarycompany.db.DbClient;

import java.util.ArrayList;

public class ListClientActivity extends AppCompatActivity {

    RecyclerView listClients;
    ArrayList<Client> listArrayClients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);
        listClients = findViewById(R.id.listClient);
        listClients.setLayoutManager(new LinearLayoutManager(this));

        DbClient dbClient = new DbClient(ListClientActivity.this);

        listArrayClients = new ArrayList<>();
        ListClientAdapter adapter = new ListClientAdapter(dbClient.viewAllClients());
        listClients.setAdapter(adapter);
    }
}