package com.example.timur.myenglish.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.timur.myenglish.model.Word;
import com.example.timur.myenglish.model.api.FindProgressModel;
import com.example.timur.myenglish.model.db.SQLi;
import com.example.timur.myenglish.view.TaskBtnActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by slava on 19.03.2017.
 */

public class Configs {
    public static void hasProgress(Activity activity){
        // TODO: 20.03.2017
        FindProgressModel model = new FindProgressModel();
        model.execute(Info.getUserId(), Info.getCurrentUnit(), activity);
    }

    public static String timeNow(){
        Calendar c = Calendar.getInstance();
        StringBuilder builder = new StringBuilder();
        builder.append(c.get(Calendar.YEAR));

        builder.append("-");
        if (String.valueOf(c.get(Calendar.MONTH) + 1).length() == 1)
            builder.append("0");
        builder.append(c.get(Calendar.MONTH) + 1);

        builder.append("-");
        if (String.valueOf(c.get(Calendar.DAY_OF_MONTH)).length() == 1)
            builder.append("0");
        builder.append(c.get(Calendar.DAY_OF_MONTH));
        return String.valueOf(builder);
    }

    public static int timeToInt(String time){
        StringTokenizer tokenizer = new StringTokenizer(time);
        int year = Integer.parseInt(tokenizer.nextToken("-"));
        int month = Integer.parseInt(tokenizer.nextToken("-"));
        int day = Integer.parseInt(tokenizer.nextToken());
        return year * 400 + month * 31 + day;

    }

    public static void generateTask(Context context){
        Random rand = new Random();
        int randomTask = rand.nextInt(3) + 1;
        Intent intentTask = null;
        SQLi unitModel = new SQLi(context);

        Bundle bundle = new Bundle();
        Word word = unitModel.selectWord(Info.getCurrentWordId());
        ArrayList<Word> words = unitModel.getWords(word);

        bundle.putSerializable("words", words);
        bundle.putSerializable("word", word);

        switch (randomTask) {
            case Constants.Tasks.TASK_TRANSLATE:
                intentTask = new Intent(context, TaskBtnActivity.class);
                intentTask.putExtra("words", words);
                intentTask.putExtra("word", word);
                intentTask.putExtra("mode", Constants.Tasks.TASK_TRANSLATE);
                break;

            case Constants.Tasks.TASK_FILL_GAPS:
                intentTask = new Intent(context, TaskBtnActivity.class);
                intentTask.putExtra("words", words);
                intentTask.putExtra("word", word);
                intentTask.putExtra("mode", Constants.Tasks.TASK_FILL_GAPS);
                break;

            case Constants.Tasks.TASK_MEANING:
                intentTask = new Intent(context, TaskBtnActivity.class);
                intentTask.putExtra("words", words);
                intentTask.putExtra("word", word);
                intentTask.putExtra("mode", Constants.Tasks.TASK_MEANING);
                break;

            case Constants.Tasks.TASK_FIND_SYNONYM:
                intentTask = new Intent(context, TaskBtnActivity.class);
                break;

            case Constants.Tasks.TASK_FIND_ANTONYM:
                intentTask = new Intent(context, TaskBtnActivity.class);
                break;
        }

        context.startActivity(intentTask);
    }

}
