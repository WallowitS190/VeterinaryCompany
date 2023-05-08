package com.example.veterinarycompany.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veterinarycompany.R;
import com.example.veterinarycompany.classes.Client;

import java.util.ArrayList;

public class ListClientAdapter extends RecyclerView.Adapter<ListClientAdapter.ClientViewHolder> {

    ArrayList<Client> listClient;

    public ListClientAdapter(ArrayList<Client> listClient){
        this.listClient = listClient;
    }


    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_client,null,false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        holder.viewName.setText(listClient.get(position).getNames());
        holder.viewLastName.setText(listClient.get(position).getLastNames());
        holder.viewPhone.setText(listClient.get(position).getPhone());
        holder.viewAddress.setText(listClient.get(position).getAddress());
        holder.viewDate.setText(listClient.get(position).getBirthday());
    }

    @Override
    public int getItemCount() {
        return listClient.size();
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder{

        TextView viewName, viewLastName, viewPhone, viewAddress, viewDate;
        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);

            viewName  = itemView.findViewById(R.id.nameClient);
            viewLastName  = itemView.findViewById(R.id.lastNameClient);
            viewPhone  = itemView.findViewById(R.id.phoneClient);
            viewAddress  = itemView.findViewById(R.id.addressClient);
            viewDate = itemView.findViewById(R.id.dateClient);
        }
    }

}
