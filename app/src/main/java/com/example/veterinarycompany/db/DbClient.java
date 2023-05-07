package com.example.veterinarycompany.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}
