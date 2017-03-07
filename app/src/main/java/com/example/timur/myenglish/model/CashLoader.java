package com.example.timur.myenglish.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alex on 02.03.2017.
 */

public class CashLoader extends Activity {
    // это будет именем файла кэша
    private static final String APP_PREFERENCES = "mysettings";
    private static SharedPreferences sharedPreferences;

    //метод записи в кэш Stringового файла
    public static void saveString(String key, String data, Activity activity){
        sharedPreferences = activity.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, data);
        editor.apply();
    }

    //метод загрузки из кэша Stringового файла
    public static String loadString(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        String value = "Sorry, check key";
        if (sharedPreferences.contains(key)){
            value = sharedPreferences.getString(key, "");
        }
        return value;
    }
}


