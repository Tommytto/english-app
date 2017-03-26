package com.example.timur.myenglish.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timur.myenglish.model.Word;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by timur on 25.02.17.
 */

public class SQLi {
    private SQLiteDatabase db;

    public SQLi(Context context) {
        //Подключение к базе данных
        db = new DBConnection(context).getWritableDatabase();
    }

    public Word getWord(int unit) {
        Cursor cursor = db.rawQuery(
                "SELECT * from words WHERE num != 0 AND unit = " + unit + " ORDER BY RANDOM() LIMIT 1;",
                null);
        cursor.moveToFirst();

        return new Word(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getInt(5),
                cursor.getInt(6), cursor.getString(7),
                cursor.getString(8), cursor.getString(9),
                cursor.getInt(10));
    }

    public Word selectWord(int num){
        Cursor cursor = db.rawQuery(
                "SELECT * from words WHERE num = " + num + ";",
                null);
        cursor.moveToFirst();

        return new Word(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getInt(5),
                cursor.getInt(6), cursor.getString(7),
                cursor.getString(8), cursor.getString(9),
                cursor.getInt(10));

    }

    public ArrayList<Word> getWords(Word word) {
        Cursor cursor = db.rawQuery(
                "SELECT * from words WHERE num != 0 AND num !=" + word.getNum() +
                        " AND unit <=" + word.getUnit() +
//                        " AND pos = \"" + word.getPos() + "\"" +
                        " ORDER BY RANDOM() LIMIT 3;",
                null);
        ArrayList<Word> words = new ArrayList<Word>();
        while (cursor.moveToNext()){
            words.add(new Word(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getInt(5),
                    cursor.getInt(6), cursor.getString(7),
                    cursor.getString(8), cursor.getString(9),
                    cursor.getInt(10)));
        }
        words.add(word);
        Collections.shuffle(words);
        return words;
    }

    public void addWord(Word word){
        ContentValues cv = new ContentValues();
        cv.put("num", word.getNum());
        cv.put("lang1", word.getLang1());
        cv.put("def1", word.getDef1());
        cv.put("lang2", word.getLang2());
        cv.put("def2", word.getDef2());
        cv.put("synid", word.getSynId());
        cv.put("oppid", word.getOppId());
        cv.put("pos", word.getPos());
        cv.put("sent1", word.getSent1());
        cv.put("sent2", word.getSent2());
        cv.put("unit", word.getUnit());
        db.insert("words", null, cv);
    }

    public void deleteAll(){
        db.execSQL("DELETE FROM words");
    }
}
