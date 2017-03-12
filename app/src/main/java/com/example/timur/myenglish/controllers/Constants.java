package com.example.timur.myenglish.controllers;

/**
 * Created by Alex on 12.03.2017.
 */

public class Constants {
    private static final String APP_PREFERENCES = "mysettings";
    private static final int TASK_TRANSLATE = 1;
    private static final int TASK_FILL_GAPS = 2;
    private static final int TASK_MEANING = 3;
    private static final int TASK_FIND_SYNONYM = 4;
    private static final int TASK_FIND_ANTONYM = 5;
    private static final int FAIL_REQUEST = -2;
    private static final int IS_USER = 0;
    private static final int IS_ADMIN = 1;
    private static final int IS_NOT_USER = -1;
    private static final String DB_NAME = "eng_app";
    private static final int DATABASE_VERSION = 1;

    public static String getAppPreferences() {
        return APP_PREFERENCES;
    }

    public static int getTaskTranslate() {
        return TASK_TRANSLATE;
    }

    public static int getTaskFillGaps() {
        return TASK_FILL_GAPS;
    }

    public static int getTaskMeaning() {
        return TASK_MEANING;
    }

    public static int getTaskFindSynonym() {
        return TASK_FIND_SYNONYM;
    }

    public static int getTaskFindAntonym() {
        return TASK_FIND_ANTONYM;
    }

    public static int getFailRequest() {
        return FAIL_REQUEST;
    }

    public static int getIsUser() {
        return IS_USER;
    }

    public static int getIsAdmin() {
        return IS_ADMIN;
    }

    public static int getIsNotUser() {
        return IS_NOT_USER;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
