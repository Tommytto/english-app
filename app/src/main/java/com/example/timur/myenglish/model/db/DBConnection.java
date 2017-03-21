package com.example.timur.myenglish.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.timur.myenglish.controllers.Constants;

/**
 * Created by timur on 25.02.17.
 */

public class DBConnection extends SQLiteOpenHelper {

    private Context context;
    private SQLiteDatabase dataBase;

    public DBConnection(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE words (\n" +
                "  `num` INTEGER NOT NULL,\n" +
                "  `lang1` TEXT,\n" +
                "  `def1`  TEXT,\n" +
                "  `lang2` TEXT,\n" +
                "  `def2`  TEXT,\n" +
                "  `synid` INTEGER DEFAULT NULL,\n" +
                "  `oppid` INTEGER DEFAULT NULL,\n" +
                "  `pos` TEXT,\n" +
                "  `sent1` TEXT,\n" +
                "  `sent2` TEXT,\n" +
                "  `unit` INTEGER\n" +
                ");");
        this.dataBase = db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tableName");
        onCreate(db);
    }
}
