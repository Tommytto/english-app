package com.example.timur.myenglish.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by timur on 25.02.17.
 */

public class SQueryFactory {
    private SQLiteDatabase db;

    public SQueryFactory(Context context) {
        //Подключение к базе данных
        db = new DBConnection(context).getWritableDatabase();
    }

    public Word getWord() {
        Cursor cursor = db.rawQuery(
                "SELECT * from words WHERE num != 0 ORDER BY RANDOM() LIMIT 1;",
                null);
        cursor.moveToFirst();

        return new Word(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getInt(5),
                cursor.getInt(6), cursor.getString(7),
                cursor.getString(8), cursor.getString(9));
    }

    public ArrayList<Word> getWords(Word word) {
        Cursor cursor = db.rawQuery(
                "SELECT * from words WHERE num != 0 AND num !=" + word.getNum() + " ORDER BY RANDOM() LIMIT 3;",
                null);
        ArrayList<Word> words = new ArrayList<Word>();
        while (cursor.moveToNext()){
            words.add(new Word(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getInt(5),
                    cursor.getInt(6), cursor.getString(7),
                    cursor.getString(8), cursor.getString(9)));
        }
        words.add(word);
        Collections.shuffle(words);
        return words;
    }
}
