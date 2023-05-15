package com.example.veterinarycompany.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.activities.client.WatchClientActivity;
import com.example.veterinarycompany.classes.Pet;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListPetAdapter extends RecyclerView.Adapter<ListPetAdapter.PetViewHolder> {

    ArrayList<Pet> listPets;

    public ListPetAdapter(ArrayList<Pet> listPets) {this.listPets = listPets; }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pet,null,false);
        return new ListPetAdapter.PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPetAdapter.PetViewHolder holder, int position) {
        holder.viewName.setText(listPets.get(position).getName());
        holder.viewAge.setText(String.valueOf(listPets.get(position).getAge()));
        holder.viewRace.setText(listPets.get(position).getRace());
    }

    @Override
    public int getItemCount() {
        return listPets.size();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder{

        TextView viewName, viewAge, viewRace,viewSex;

        public PetViewHolder(@NonNull View itemView){
            super(itemView);

            viewName = itemView.findViewById(R.id.namePet);
            viewAge = itemView.findViewById(R.id.agePet);
            viewRace = itemView.findViewById(R.id.racePet);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, WatchClientActivity.class);
                    intent.putExtra("ID",listPets.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
