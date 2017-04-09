package com.example.timur.myenglish.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.timur.myenglish.controllers.Constants;

import static android.content.ContentValues.TAG;

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


    public static String loadString(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        String value = null;
        if (sharedPreferences.contains(key)){
            value = sharedPreferences.getString(key, "");
        }
        return value;
    }

    // Инкремент количества пройденных заданий в день
    public static void addToDailyLimit(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int currentValue = loadDailyLimit(key,activity) + 1;
        editor.putInt(key, currentValue);
        editor.apply();

        Log.d(TAG, "cash add " + sharedPreferences.getInt(key,0));
        Log.d(TAG, "cash add to " + loadDailyLimit(key,activity));
    }

    // Получений пройденных задание за сегодня
    public static int loadDailyLimit(String key, Activity activity){
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        int value;
        if (sharedPreferences.contains(key)){
            value = sharedPreferences.getInt(key,0);
            Log.d(TAG, "cash load " + sharedPreferences.getInt(key,0));
        } else {
            value = 0;
        }
        return value;
    }

    // Проверка на пройденные сутки и сброс счетчика пройденных заданий
    public static void isEndedDailyLimit(String key, long currentTime, Activity activity){
        Calendar calendar = Calendar.getInstance();
        long lastTaskTime = getLastTaskTime("lastTaskTime", activity);
//        long millisPerDay = 864 * 10^5;
        long millisPerDay = 20000;
        Log.d(TAG, "inTIme " + (currentTime - lastTaskTime));
        if (sharedPreferences.getInt(key,0) >= 9 && (currentTime - lastTaskTime) >= millisPerDay) {
            sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(key, 0);
            editor.apply();
            Log.d(TAG, "inTIme " + (currentTime - lastTaskTime));
        }
    }

    // Кладем токен для авторизации без ввода логина и пароля
    public static void putAuthToken (String key, Activity activity) {
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean isAuth = true;
        editor.putBoolean(key, isAuth);
        editor.apply();
    }

    // Убираем токен из кэша
    public static void removeAuthToken (String key, Activity activity) {
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    // Проверка на наличие токена авторизации в кэше
    public static boolean checkAuthToken (String key, Activity activity) {
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        boolean value = false;
        if (sharedPreferences.contains(key)){
            value = sharedPreferences.getBoolean(key,false);
        }
        return value;
    }

    // Кладем время последнего решенного таска
    public static void putLastTaskTime (String key, Activity activity) {
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis();
        editor.putLong(key, currentTime);
        editor.apply();
    }

    public static long getLastTaskTime (String key, Activity activity) {
        sharedPreferences = activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        long currentTime = 0;
        if (sharedPreferences.contains(key)){
            currentTime = sharedPreferences.getLong(key,0);
        }
        return currentTime;
    }
}


