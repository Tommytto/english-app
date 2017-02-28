package com.example.timur.myenglish.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by timur on 25.02.17.
 */

public class DBConnection extends SQLiteOpenHelper {

    private static final String DB_NAME = "eng_app";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    private SQLiteDatabase dataBase;

    public DBConnection(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        Log.d(TAG, "CREATING NEW DATABASE" + new SQueryFactory(context).getWord());
        db.execSQL("CREATE TABLE words (" +
                " num INTEGER NOT NULL," +
                " lang1 TEXT ," +
                " def1 TEXT," +
                " lang2 TEXT," +
                " def2 TEXT," +
                " synid INTEGER DEFAULT NULL," +
                " oppid INTEGER DEFAULT NULL," +
                " pos TEXT," +
                " sent1 TEXT," +
                " sent2 TEXT)");
        db.execSQL("INSERT INTO words (num, lang1, def1, lang2, def2, synid, oppid, pos, sent1, sent2) VALUES (0, '', '', '', '', 0, 0, '', '', '')");
        db.execSQL("INSERT INTO words (num, lang1, def1, lang2, def2, synid, oppid, pos, sent1, sent2) VALUES (1, 'bias', 'inclination for or against', 'предвзятость', '', 11, 0, 'n', 'The townspeople show a bias in favour of French habits and fashions.', 'Numbers ending in \"5\" have been rounded to the nearest multiple of 20 to prevent systematic bias.')");
        db.execSQL("INSERT INTO words (num, lang1, def1, lang2, def2, synid, oppid, pos, sent1, sent2) VALUES (2, 'breach', 'an act of breaking, esp. an agreement', 'нарушение', '', 15, 0, 'n', '\"We have a security breach,\" the general said, his voice unsteady.', 'A breach of the covenant to repair gives the landlord an action for damages')");
        db.execSQL("INSERT INTO words (num, lang1, def1, lang2, def2, synid, oppid, pos, sent1, sent2) VALUES (3, 'displease', 'cause bad feelings', 'раздражать', '', 9, 0, 'v', 'Low returns will surely displease our investors.', '')");
        db.execSQL("INSERT INTO words (num, lang1, def1, lang2, def2, synid, oppid, pos, sent1, sent2) VALUES (4, 'enhance', 'increase, intensify, improve', 'усиливать', '', 0, 0, 'v', 'We need to enhance this equipment to be useful.', '')");
        this.dataBase = db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
