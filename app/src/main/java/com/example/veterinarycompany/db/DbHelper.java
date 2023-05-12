package com.example.veterinarycompany.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "veterinary.db";
    protected static final String TABLE_CLIENT = "t_client";
    protected static final String TABLE_PET = "t_pet";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CLIENT +
                "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "names TEXT NOT NULL," +
                "last_names TEXT NOT NULL," +
                "birthday TEXT NOT NULL, " +
                "address TEXT NOT NULL, "+
                "phone TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PET +
                "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "names TEXT NOT NULL," +
                "age INTEGER NOT NULL," +
                "race TEXT NOT NULL, " +
                "sex TEXT NOT NULL, "+
                "id_owner INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CLIENT);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PET);
        onCreate(sqLiteDatabase);
    }
}
