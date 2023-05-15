package com.example.veterinarycompany.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUser extends DbHelper {

    Context context;

    DbHelper dbHelper;
    SQLiteDatabase db;
    ContentValues values;

    public DbUser(@Nullable Context context) {
        super(context);
        this.context = context;

        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        values = new ContentValues();
    }

    public long insertUser(String names, String username, String password) {

        long id = 0;

        try {
            values.put("names", names);
            values.put("username", username);
            values.put("password", password);

            id = db.insert(TABLE_USER, null, values);
        }
        catch(Exception ex) {
            ex.toString();
        }

        return id;
    }

    public boolean existUser(String username, String password) {

        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();

        boolean existUser = false;
        Cursor cursorUser;

        cursorUser = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE username = '" + username + "' AND password = '" + password + "'", null);

        if(cursorUser.moveToFirst()){
            existUser = true;
        }

        cursorUser.close();

        return existUser;
    }

}
