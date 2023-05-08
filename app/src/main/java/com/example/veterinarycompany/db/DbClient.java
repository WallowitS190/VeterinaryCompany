package com.example.veterinarycompany.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.veterinarycompany.classes.Client;

import java.util.ArrayList;

public class DbClient extends DbHelper {

    Context context;

    DbHelper dbHelper;
    SQLiteDatabase db;
    ContentValues values;

    public DbClient(@Nullable Context context) {
        super(context);
        this.context = context;

        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        values = new ContentValues();
    }

    public long insertClient(String names, String lastNames, String birthday, String address, String phone) {

        long id = 0;

        try {
            values.put("names", names);
            values.put("last_names", lastNames);
            values.put("birthday", birthday);
            values.put("address", address);
            values.put("phone", phone);

            id = db.insert(TABLE_CLIENT, null, values);
        }
        catch(Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<Client> viewAllClients(){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();

        ArrayList<Client> listClients = new ArrayList<>();
        Client clients = null;
        Cursor cursorClients = null;

        cursorClients = db.rawQuery("SELECT * FROM " + TABLE_CLIENT, null);

        if(cursorClients.moveToFirst()){
            do {
                clients = new Client();
                clients.setId(cursorClients.getInt(0));
                clients.setNames(cursorClients.getString(1));
                clients.setLastNames(cursorClients.getString(2));
                clients.setAddress(cursorClients.getString(3));
                clients.setBirthday(cursorClients.getString(4));
                clients.setPhone(cursorClients.getString(5));
                listClients.add(clients);
            } while (cursorClients.moveToNext());
        }
        cursorClients.close();

        return listClients;
    }
}
