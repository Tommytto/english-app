package com.example.timur.myenglish.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.UChooseListener;
import com.example.timur.myenglish.model.SQueryFactory;
import com.example.timur.myenglish.model.Word;
import com.example.timur.myenglish.view.TaskBtnActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by timur on 05.03.17.
 *
 * Контролер для рандомного запуска заданий
 */
public class TaskController extends Activity {

    private static final int TASK_TRANSLATE = 1;
    private static final int TASK_FILL_GAPS = 2;
    private static final int TASK_MEANING = 3;
    private static final int TASK_FIND_SYNONYM = 4;
    private static final int TASK_FIND_ANTONYM = 5;

    private Random rand = new Random();
    private int randomTask = rand.nextInt(3) + 1;
    private Intent intentTask;
    private Bundle bundle = new Bundle();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQueryFactory unitModel = new SQueryFactory(this);
        Word word = unitModel.getWord();
        ArrayList<Word> words = unitModel.getWords(word);

        bundle.putSerializable("words", words);
        bundle.putSerializable("word", word);

        switch (randomTask) {
            case TASK_TRANSLATE:
                intentTask = new Intent(this, TaskBtnActivity.class);
                intentTask.putExtra("mode", TASK_TRANSLATE);
                intentTask.putExtras(bundle);
                break;

            case TASK_FILL_GAPS:
                intentTask = new Intent(this, TaskBtnActivity.class);
                intentTask.putExtra("mode", TASK_FILL_GAPS);
                intentTask.putExtras(bundle);
                break;

            case TASK_MEANING:
                intentTask = new Intent(this, TaskBtnActivity.class);
                intentTask.putExtra("mode", TASK_MEANING);
                intentTask.putExtras(bundle);
                break;

            case TASK_FIND_SYNONYM:
                intentTask = new Intent(this, TaskBtnActivity.class);
                break;

            case TASK_FIND_ANTONYM:
                intentTask = new Intent(this, TaskBtnActivity.class);
                break;
        }

        this.startActivity(intentTask);
    }

}
