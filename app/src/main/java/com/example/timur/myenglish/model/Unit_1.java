package com.example.timur.myenglish.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 25.02.17.
 */

public class Unit_1 {
    private SQLiteDatabase db;

    public Unit_1(Context context) {
        //Подключение к базе данных
        db = new DBConnection(context).getWritableDatabase();
    }

    public String getWord() {
        //Вывод записей с отбором (where!=null) и без
        Cursor cursor = db.rawQuery("SELECT lang1 from words ORDER BY random() LIMIT 1;", null);

        return cursor.getString(0);
    }
}
