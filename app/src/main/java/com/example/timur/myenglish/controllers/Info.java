package com.example.timur.myenglish.controllers;

/**
 * Created by slava on 19.03.2017.
 */

public class Info {
    private static int unit = -1;
    private static int userId = -1;
    private static int currentUnit = -1;

    public static int getCurrentWordId() {
        return currentWordId;
    }

    public static void setCurrentWordId(int currentWordId) {
        Info.currentWordId = currentWordId;
    }

    private static int currentWordId = -1;


    public static int getCurrentUnit() {
        return currentUnit;
    }

    public static void setCurrentUnit(int currentUnit) {
        Info.currentUnit = currentUnit;
    }

    public static int getUnit() {
        return unit;
    }

    public static void setUnit(int unit) {
        Info.unit = unit;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        Info.userId = userId;
    }
}
