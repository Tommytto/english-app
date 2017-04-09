package com.example.timur.myenglish.controllers;

/**
 * Created by Alex on 12.03.2017.
 */

public class Constants {
    public static final String APP_PREFERENCES = "mysettings";
    public static final String DB_NAME = "eng_app";
    public static final int DATABASE_VERSION = 1;
    public static final int NOT_IDENTIFIED = -1;
    public static final int MAXUNIT = 1;
    public class Tasks{
        public static final int TASK_TRANSLATE = 1;
        public static final int TASK_FILL_GAPS = 2;
        public static final int TASK_MEANING = 3;
        public static final int TASK_FIND_SYNONYM = 4;
        public static final int TASK_FIND_ANTONYM = 5;
    }
    public class UserTypes{
        public static final int IS_USER = 0;
        public static final int IS_ADMIN = 1;
        public static final int IS_NOT_USER = -1;
        public static final int FAIL_REQUEST = -2;
    }
    public class Codes{
        public static final String AUTH = "ZhmCGGXeey";
        public static final String GETWORDS = "ROPEAeFcq4";
        public static final String GETPROGRESSES = "GmCAnf8u78";
        public static final String GETDATE = "l0lp4aztwV";
        public static final String ADDPROGRESS = "uRHWBFRL8J";
        public static final String SETDATE = "PCDh8MPti9";
        public static final String FINDPROGRESS = "XoXK3wMkDN";
        public static final String UPDATEPROGRESS = "r0f4g0eR32";
        public static final String FIRSTSIGN = "FQsMsoArQ5";
        public static final String UPDATEUNIT = "6n0l2HdZch" ;
    }

    public class Cash {
        public static final String UNIT_ID_CASH = "UNIT_ID_CASH";
        public static final String USER_ID_CASH = "USER_ID_CASH";
        public static final String LAST_TASK_TIME_CASH = "LAST_TASK_TIME_CASH";
        public static final String AUTH_TOKEN_CASH = "AUTH_TOKEN_CASH";
        public static final String TASKS_DAILY_LIMIT_CASH = "TASKS_DAILY_LIMIT_CASH";
    }
}
