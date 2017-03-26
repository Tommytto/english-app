package com.example.timur.myenglish.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.timur.myenglish.controllers.Constants;

/**
 * Created by Alex on 02.03.2017.
 */

public class CashLoader extends Activity {
    // это будет именем файла кэша
    private static SharedPreferences sharedPreferences;

    //метод записи в кэш Stringового файла
    public static void saveString(String key, String data, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, data);
        editor.apply();
    }

    //метод загрузки из кэша Stringового файла
    public static String loadString(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        String value = null;
        if (sharedPreferences.contains(key)){
            value = sharedPreferences.getString(key, "");
        }
        return value;
    }

    //метод записи в кэш Stringового файла
    public static void addToDailyLimit(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int currentValue = loadDailyLimit(key, activity) + 1;
        editor.putInt(key, currentValue);
        editor.apply();
    }

    //метод загрузки из кэша Stringового файла
    public static int loadDailyLimit(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        int value = 0;
        if (sharedPreferences.contains(key)){
            value = sharedPreferences.getInt(key,0);
        }
        return value;
    }
}


