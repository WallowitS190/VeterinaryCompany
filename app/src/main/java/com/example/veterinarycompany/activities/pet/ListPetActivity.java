package com.example.veterinarycompany.activities.pet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.adaptadores.ListPetAdapter;
import com.example.veterinarycompany.classes.Pet;
import com.example.veterinarycompany.db.DbPet;

import java.util.ArrayList;

public class ListPetActivity extends AppCompatActivity {

    RecyclerView listPets;
    ArrayList<Pet> listArrayPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pet);

        listPets = findViewById(R.id.listPets);
        listPets.setLayoutManager(new LinearLayoutManager(this));

        DbPet dbPet = new DbPet(ListPetActivity.this);

        ListPetAdapter adapter = new ListPetAdapter(dbPet.viewAllPet());
        listPets.setAdapter(adapter);
    }
}